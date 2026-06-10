package circuitbreaker;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class CircuitBreaker {

    public enum State{
        CLOSED,
        OPEN,
        HALF_OPEN
    }

    private final int failureThreshold;
    private final long resetTimeoutInMillis;

    private volatile int failureCount;
    private volatile long lastFailureTime;
    private volatile State state;

    private final ReentrantLock lock = new ReentrantLock();

    public CircuitBreaker(int failureThreshold, long resetTimeoutInMillis) {
        this.failureThreshold = failureThreshold;
        this.resetTimeoutInMillis = resetTimeoutInMillis;
        this.state = State.CLOSED;
        this.failureCount = 0;
    }

    public <T> T execute(Supplier<T> action){
        evaluateState();
        if(state == State.OPEN){
            throw new CircuitBreakerOpenException("Circuit breaker is open Request blocked");
        }
        try {
            T result = action.get();
            recordSuccess();
            return result;
        }catch (Exception e){
            recordFailure();
            throw e;
        }
    }

    private void evaluateState(){
        if(state == State.OPEN){
            lock.lock();
            try {
                if(state == State.OPEN){
                    long currentTime = System.currentTimeMillis();
                    if(currentTime - lastFailureTime >= resetTimeoutInMillis){
                        state = State.HALF_OPEN;
                        System.out.println("[state change] Open -> half open ready to test the circuit");
                    }
                }
            }finally {
                lock.unlock();
            }
        }
    }

    private void recordSuccess(){
        lock.lock();
        try {
            if(state == State.HALF_OPEN){
                System.out.println("[State change] HALF_OPEN -> closed service recovered");
            }
            failureCount = 0;
            state = State.CLOSED;
        }finally {
            lock.unlock();
        }
    }

    private void recordFailure(){
        lock.lock();
        try {
            failureCount++;
            lastFailureTime = System.currentTimeMillis();
            if(state == State.HALF_OPEN){
                state = State.OPEN;
                System.out.println("[state change] HALF_OPEN -> Open service still failing");
            } else if (state == State.CLOSED && failureCount >= failureThreshold) {
                state = State.OPEN;
                System.out.println("[state change] CLOSED -> OPEN failure threshold reached");
            }
        }finally {
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
