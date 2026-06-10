# Low-Level Design: Circuit Breaker Pattern

## 1. Problem Statement
In distributed systems, microservices frequently communicate with remote resources or other services over the network. When a remote service becomes unresponsive or exhibits high latency, continuously retrying the request can consume critical resources (threads, memory, connections) and cause cascading failures across the entire system.

The Circuit Breaker pattern solves this by acting as a stateful proxy. It monitors the failure rates of remote calls and, upon reaching a configured threshold, temporarily blocks subsequent calls (opening the circuit). This gives the failing service time to recover and prevents the calling service from wasting resources on doomed requests.

## 2. Requirements and Scope

### Functional Requirements
* **Failure Tracking:** The system must count consecutive failures of a wrapped operation.
* **State Management:** The circuit must transition between three core states: `CLOSED` (healthy), `OPEN` (failing), and `HALF_OPEN` (testing recovery).
* **Fast Failure:** When the circuit is `OPEN`, incoming requests must be immediately rejected without attempting the remote call.
* **Self-Healing:** After a configurable timeout, the system must allow a limited number of test requests (`HALF_OPEN`) to check if the remote service has recovered.

### Non-Functional Requirements
* **Thread Safety:** The circuit breaker must safely handle concurrent requests from multiple threads.
* **Extensibility:** The component should be generic enough to wrap any arbitrary method or remote call.

### Scope / Out of Scope
* **In Scope:** Single-node, in-memory state tracking. Standard exception-based failure detection.
* **Out of Scope:** Distributed state management (e.g., sharing failure states across multiple nodes via Redis). Advanced failure filtering (e.g., ignoring `400 Bad Request` but tripping on `500 Internal Server Error`). Dynamic threshold adjustments based on load.

## 3. Design and System Flow
The system operates as a lightweight State Machine wrapped around a proxy execution method.

**Execution Flow:**
1. A client submits an action (via `Supplier<T>`) to the `execute` method.
2. The system checks the current state:
   * If `OPEN`: Checks if the `resetTimeoutInMillis` has elapsed since the last failure. If yes, it transitions to `HALF_OPEN`. If no, it immediately throws a `CircuitBreakerOpenException`.
3. The system attempts to execute the supplier action.
   * **On Success:** It clears the `failureCount` and forces the state to `CLOSED` (healing the circuit if it was `HALF_OPEN`).
   * **On Exception:** It increments the `failureCount`, updates the `lastFailureTime`, and transitions to `OPEN` if the `failureThreshold` is met or if the state was `HALF_OPEN`.

### State Diagram
```mermaid
stateDiagram-v2
    [*] --> CLOSED
    CLOSED --> OPEN : Failures >= failureThreshold
    OPEN --> HALF_OPEN : resetTimeoutInMillis elapsed
    HALF_OPEN --> OPEN : Test request fails
    HALF_OPEN --> CLOSED : Test request succeeds