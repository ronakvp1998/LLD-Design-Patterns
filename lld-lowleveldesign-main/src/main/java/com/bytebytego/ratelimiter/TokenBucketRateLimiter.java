package com.bytebytego.ratelimiter;

/**
 * Interface representing a generic Rate Limiter.
 */
 interface RateLimiter {
    /**
     * Checks if a request is allowed to proceed.
     * @return true if the request is allowed, false if rate limited.
     */
    boolean allowRequest();
}

/**
 * Thread-safe implementation of a Rate Limiter using the Token Bucket algorithm.
 */
public class TokenBucketRateLimiter implements RateLimiter {

    private final long maxBucketSize;
    private final long refillRatePerSecond;

    private double currentBucketSize;
    private long lastRefillTimestamp;

    /**
     * @param maxBucketSize       Maximum number of tokens the bucket can hold.
     * @param refillRatePerSecond Number of tokens added to the bucket every second.
     */
    public TokenBucketRateLimiter(long maxBucketSize, long refillRatePerSecond) {
        if (maxBucketSize <= 0 || refillRatePerSecond <= 0) {
            throw new IllegalArgumentException("Bucket size and refill rate must be greater than 0");
        }
        this.maxBucketSize = maxBucketSize;
        this.refillRatePerSecond = refillRatePerSecond;

        // Start with a full bucket
        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimestamp = System.nanoTime();
    }

    @Override
    public synchronized boolean allowRequest() {
        return allowRequest(1);
    }

    /**
     * Checks if a specific number of tokens can be consumed.
     */
    public synchronized boolean allowRequest(int tokens) {
        refill();

        if (currentBucketSize >= tokens) {
            currentBucketSize -= tokens;
            return true;
        }
        return false; // Rate limited
    }

    /**
     * Lazily refills the bucket based on the time elapsed since the last refill.
     * We calculate this on-the-fly to avoid using a background thread.
     */
    private void refill() {
        long now = System.nanoTime();
        double elapsedTimeInSeconds = (now - lastRefillTimestamp) / 1_000_000_000.0;

        // Calculate how many tokens to add based on elapsed time
        double tokensToAdd = elapsedTimeInSeconds * refillRatePerSecond;

        if (tokensToAdd > 0) {
            // Add tokens, but cap it at the maximum bucket size
            currentBucketSize = Math.min(maxBucketSize, currentBucketSize + tokensToAdd);
            lastRefillTimestamp = now;
        }
    }
}