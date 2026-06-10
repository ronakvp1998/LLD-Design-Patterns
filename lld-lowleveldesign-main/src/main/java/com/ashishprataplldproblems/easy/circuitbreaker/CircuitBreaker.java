package com.ashishprataplldproblems.easy.circuitbreaker;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * Low-Level Design of a Circuit Breaker using Locks.
 */
public class CircuitBreaker {

    public enum State {
        CLOSED,
        OPEN,
        HALF_OPEN
    }

    private final int failureThreshold;
    private final long resetTimeoutInMillis;

    // Volatile for read-visibility across threads without locking
    private volatile int failureCount;
    private volatile long lastFailureTime;
    private volatile State state;
    
    // Lock to protect state mutations
    private final ReentrantLock lock = new ReentrantLock();

    public CircuitBreaker(int failureThreshold, long resetTimeoutInMillis) {
        this.failureThreshold = failureThreshold;
        this.resetTimeoutInMillis = resetTimeoutInMillis;
        this.state = State.CLOSED;
        this.failureCount = 0;
    }

    /**
     * Executes the given action wrapped in the circuit breaker logic.
     * The remote call (action.get()) is executed outside the lock to prevent thread bottlenecking.
     */
    public <T> T execute(Supplier<T> action) {
        evaluateState();

        if (state == State.OPEN) {
            throw new CircuitBreakerOpenException("Circuit breaker is OPEN. Request blocked.");
        }

        try {
            // Execute the action without holding the lock! 
            // This allows concurrent executions when CLOSED.
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
            lock.lock();
            try {
                // Double-checked locking to ensure only one thread promotes to HALF_OPEN
                if (state == State.OPEN) {
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastFailureTime >= resetTimeoutInMillis) {
                        state = State.HALF_OPEN;
                        System.out.println("[State Change] OPEN -> HALF_OPEN. Ready to test the circuit.");
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void recordSuccess() {
        lock.lock();
        try {
            if (state == State.HALF_OPEN) {
                System.out.println("[State Change] HALF_OPEN -> CLOSED. Service recovered.");
            }
            // Reset counters and restore health
            failureCount = 0;
            state = State.CLOSED;
        } finally {
            lock.unlock();
        }
    }

    private void recordFailure() {
        lock.lock();
        try {
            failureCount++;
            lastFailureTime = System.currentTimeMillis();

            if (state == State.HALF_OPEN) {
                state = State.OPEN;
                System.out.println("[State Change] HALF_OPEN -> OPEN. Service still failing.");
            } else if (state == State.CLOSED && failureCount >= failureThreshold) {
                state = State.OPEN;
                System.out.println("[State Change] CLOSED -> OPEN. Failure threshold reached.");
            }
        } finally {
            lock.unlock();
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