package com.ashishprataplldproblems.lrucache;

public class LRUMain {
    public static void main(String[] args) {
        System.out.println("--- Starting LRU Cache Tests ---\n");

        // 1. Initialize cache with a capacity of 3
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        System.out.println("Cache initialized with capacity 3.");

        // 2. Add some initial values
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        System.out.println("Inserted keys: 1, 2, 3");

        // Internal order is now: [3, 2, 1] (where 3 is most recently used)

        // 3. Test retrieving an item (makes it most recently used)
        System.out.println("Get key 1: " + cache.get(1));
        // Expected: "One". Internal order is now: [1, 3, 2]

        // 4. Test eviction (cache is full, so adding a 4th item evicts the LRU item)
        System.out.println("\nInserting key 4...");
        cache.put(4, "Four");
        // Key 2 was the Least Recently Used, so it gets evicted. Internal order: [4, 1, 3]

        System.out.println("Get key 2 (Evicted): " + cache.get(2));
        // Expected: null

        // 5. Trigger another eviction
        System.out.println("\nInserting key 5...");
        cache.put(5, "Five");
        // Key 3 is evicted. Internal order: [5, 4, 1]

        System.out.println("Get key 3 (Evicted): " + cache.get(3));
        // Expected: null

        System.out.println("Get key 1 (Still in cache): " + cache.get(1));
        // Expected: "One". Internal order: [1, 5, 4]

        // 6. Test updating an existing key
        System.out.println("\nUpdating key 1...");
        cache.put(1, "One-Updated");
        // Key 1 is already in cache. It updates the value and moves to head.
        System.out.println("Get key 1 (Updated): " + cache.get(1));
        // Expected: "One-Updated"

        System.out.println("\n--- All Tests Completed ---");
    }
}