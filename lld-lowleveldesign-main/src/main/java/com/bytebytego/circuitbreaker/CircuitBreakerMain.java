package com.bytebytego.circuitbreaker;

public class CircuitBreakerMain {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Starting Circuit Breaker Tests ---\n");

        // Trips after 2 failures, waits 2000ms (2 seconds) before testing again
        CircuitBreaker circuitBreaker = new CircuitBreaker(2, 2000);

        // 1. Simulate Normal Operation (CLOSED)
        System.out.println("Executing successful requests...");
        executeSafely(circuitBreaker, CircuitBreakerMain::successfulRemoteCall);
        executeSafely(circuitBreaker, CircuitBreakerMain::successfulRemoteCall);

        // 2. Simulate Failures to trip the circuit (CLOSED -> OPEN)
        System.out.println("\nExecuting failing requests...");
        executeSafely(circuitBreaker, CircuitBreakerMain::failingRemoteCall); // Failure 1
        executeSafely(circuitBreaker, CircuitBreakerMain::failingRemoteCall); // Failure 2 (Trips to OPEN)f

        // 3. Attempting requests while OPEN
        System.out.println("\nExecuting request while circuit is OPEN...");
        executeSafely(circuitBreaker, CircuitBreakerMain::successfulRemoteCall); // Blocked immediately

        // 4. Wait for the timeout to expire
        System.out.println("\nWaiting for 2 seconds to trigger timeout...");
        Thread.sleep(2100);

        // 5. Test the circuit (HALF_OPEN -> CLOSED)
        System.out.println("\nExecuting request after timeout...");
        executeSafely(circuitBreaker, CircuitBreakerMain::successfulRemoteCall); // Succeeds, resets to CLOSED

        // 6. Verify normal operation is restored
        System.out.println("\nExecuting normal request to verify CLOSED state...");
        executeSafely(circuitBreaker, CircuitBreakerMain::successfulRemoteCall);

        System.out.println("\n--- All Tests Completed ---");
    }

    /**
     * Helper method to execute the circuit breaker and catch exceptions for clean output.
     */
    private static void executeSafely(CircuitBreaker cb, java.util.function.Supplier<String> call) {
        try {
            String result = cb.execute(call);
            System.out.println("Success: " + result);
        } catch (CircuitBreaker.CircuitBreakerOpenException e) {
            System.out.println("Blocked: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Failed: Underlying service threw an exception.");
        }
    }

    // --- Mock Service Methods ---

    private static String successfulRemoteCall() {
        return "200 OK - Data fetched successfully.";
    }

    private static String failingRemoteCall() {
        throw new RuntimeException("500 Internal Server Error");
    }

}
