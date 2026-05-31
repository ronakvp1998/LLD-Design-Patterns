package com.lldproblems.circuitbreaker;

import java.util.function.Supplier;

/**
 * Low-Level Design of a Circuit Breaker.
 */
public class CircuitBreaker {

    public enum State {
        CLOSED,
        OPEN,
        HALF_OPEN
    }

    private final int failureThreshold;
    private final long resetTimeoutInMillis;

    private int failureCount;
    private long lastFailureTime;
    private State state;

    public CircuitBreaker(int failureThreshold, long resetTimeoutInMillis) {
        this.failureThreshold = failureThreshold;
        this.resetTimeoutInMillis = resetTimeoutInMillis;
        this.state = State.CLOSED;
        this.failureCount = 0;
    }

    /**
     * Executes the given action wrapped in the circuit breaker logic.
     */
    public synchronized <T> T execute(Supplier<T> action) {
        evaluateState();

        if (state == State.OPEN) {
            throw new CircuitBreakerOpenException("Circuit breaker is OPEN. Request blocked.");
        }

        try {
            T result = action.get();
            recordSuccess();
            return result;
        } catch (Exception e) {
            recordFailure();
            throw e; // Re-throw the actual exception from the service
        }
    }

    /**
     * Checks if the reset timeout has passed to move from OPEN to HALF_OPEN.
     */
    private void evaluateState() {
        if (state == State.OPEN) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastFailureTime >= resetTimeoutInMillis) {
                state = State.HALF_OPEN;
                System.out.println("[State Change] OPEN -> HALF_OPEN. Ready to test the circuit.");
            }
        }
    }

    private void recordSuccess() {
        if (state == State.HALF_OPEN) {
            System.out.println("[State Change] HALF_OPEN -> CLOSED. Service recovered.");
        }

        failureCount = 0;
        state = State.CLOSED;
    }

    private void recordFailure() {
        failureCount++;
        lastFailureTime = System.currentTimeMillis();

        if (state == State.HALF_OPEN) {
            state = State.OPEN;
            System.out.println("[State Change] HALF_OPEN -> OPEN. Service still failing.");
        } else if (state == State.CLOSED && failureCount >= failureThreshold) {
            state = State.OPEN;
            System.out.println("[State Change] CLOSED -> OPEN. Failure threshold reached.");
        }
    }

    /**
     * Custom Exception for when the circuit is open.
     */
    public static class CircuitBreakerOpenException extends RuntimeException {
        public CircuitBreakerOpenException(String message) {
            super(message);
        }
    }
}