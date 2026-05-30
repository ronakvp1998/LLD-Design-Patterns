package com.bytebytego.ratelimiter;

public class RateLimiterMain {
    public static void main(String[] args) {
        System.out.println("--- Starting Rate Limiter Tests (Token Bucket) ---\n");

        // Create a bucket with max 3 tokens, refilling 1 token every second
        RateLimiter rateLimiter = new TokenBucketRateLimiter(3, 1);
        System.out.println("Rate Limiter configured: Capacity=3, Refill=1 token/sec\n");

        // 1. Simulate a sudden burst of 5 requests
        System.out.println("Simulating a burst of 5 rapid requests...");
        for (int i = 1; i <= 5; i++) {
            boolean isAllowed = rateLimiter.allowRequest();
            if (isAllowed) {
                System.out.println("Request " + i + ": SUCCESS (Token consumed)");
            } else {
                System.out.println("Request " + i + ": BLOCKED (Rate limited - No tokens)");
            }
        }

        // 2. Wait for tokens to refill
        System.out.println("\nWaiting for 2.5 seconds to allow tokens to refill...");
        try {
            Thread.sleep(2500); // Should refill ~2.5 tokens
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Try another burst of requests
        System.out.println("\nSimulating another burst of 3 requests...");
        for (int i = 1; i <= 3; i++) {
            boolean isAllowed = rateLimiter.allowRequest();
            if (isAllowed) {
                System.out.println("Request " + (i + 5) + ": SUCCESS (Token consumed)");
            } else {
                System.out.println("Request " + (i + 5) + ": BLOCKED (Rate limited - No tokens)");
            }
        }

        System.out.println("\n--- All Tests Completed ---");
    }
}
