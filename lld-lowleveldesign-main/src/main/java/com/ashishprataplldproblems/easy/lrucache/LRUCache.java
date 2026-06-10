package com.ashishprataplldproblems.easy.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Low-Level Design of a Thread-Safe LRU Cache.
 */
public class LRUCache<K, V> {

    // Doubly Linked List Node (Kept as an inner class for encapsulation)
    private class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node> cache;
    private final ReentrantLock lock; // FIXED: Added missing lock declaration

    // Dummy head and tail to avoid edge cases during insertion/deletion
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lock = new ReentrantLock();

        // Initialize dummy head and tail
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Fetches the value for the given key.
     * Moves the accessed node to the front (most recently used).
     */
    public V get(K key) {
        lock.lock(); // FIXED: Acquire lock
        try {
            if (!cache.containsKey(key)) {
                return null;
            }

            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        } finally {
            lock.unlock(); // FIXED: Release lock in finally block
        }
    }

    /**
     * Inserts or updates a key-value pair.
     * Evicts the least recently used item if the cache reaches capacity.
     */
    public void put(K key, V value) {
        lock.lock(); // FIXED: Acquire lock
        try {
            if (cache.containsKey(key)) {
                // Update existing node and move to head
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                // Create a new node
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addNode(newNode);

                // Evict LRU if capacity is exceeded
                if (cache.size() > capacity) {
                    Node lruNode = popTail();
                    cache.remove(lruNode.key);
                }
            }
        } finally {
            lock.unlock(); // FIXED: Release lock in finally block
        }
    }

    // --- Helper Methods for Doubly Linked List Operations ---
    // Note: No locks are needed here because these are private and
    // only called from within locked contexts (get/put).

    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}