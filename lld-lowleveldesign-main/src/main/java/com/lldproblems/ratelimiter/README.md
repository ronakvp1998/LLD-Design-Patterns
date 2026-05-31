# Rate Limiter Implementation in Java

This repository contains a Low-Level Design (LLD) implementation of a **Rate Limiter** in Java using the **Token Bucket** algorithm.

Rate limiting is used to control the rate of traffic sent or received by a network interface controller. It is commonly used in APIs to prevent denial-of-service (DoS) attacks, limit web scraping, and enforce usage quotas.

## 🏗️ Architecture & Algorithm

This implementation uses the **Token Bucket Algorithm**.

1. **The Bucket**: A bucket is assigned a maximum capacity (e.g., 5 tokens).
2. **The Refill**: Tokens are added to the bucket at a fixed rate (e.g., 1 token per second).
3. **The Request**: Every incoming request tries to consume a token.
    * If tokens are available, the request is processed.
    * If the bucket is empty, the request is rejected (HTTP 429 Too Many Requests).

### Lazy Refill Strategy
Instead of running a background thread that constantly wakes up to add tokens (which consumes CPU and memory), this design uses **Lazy Refilling**. The bucket size is recalculated on-the-fly exactly when a request arrives, based on the time elapsed since the last request.

## ⚡ Complexity

* **Time Complexity**: **O(1)**. Calculating the elapsed time and updating the double variable happens in constant time.
* **Space Complexity**: **O(1)**. Only a few primitives (`long`, `double`) are stored per instance.

## 🚀 Usage

```java
// Initialize a rate limiter with a max capacity of 5 tokens, refilling at 2 tokens/sec
RateLimiter rateLimiter = new TokenBucketRateLimiter(5, 2);

if (rateLimiter.allowRequest()) {
    System.out.println("Request Processed!");
} else {
    System.out.println("HTTP 429: Too Many Requests.");
}