package com.ashishprataplldproblems.easy.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * Low-Level Design of an LRU Cache.
 */
public class LRUCache<K, V> {

    // Doubly Linked List Node
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

    // Dummy head and tail to avoid edge cases during insertion/deletion
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.cache = new HashMap<>();

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
        if (!cache.containsKey(key)) {
            return null; // or throw an exception based on requirements
        }

        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    /**
     * Inserts or updates a key-value pair.
     * Evicts the least recently used item if the cache reaches capacity.
     */
    public void put(K key, V value) {
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
                Node tail = popTail();
                cache.remove(tail.key);
            }
        }
    }

    // --- Helper Methods for Doubly Linked List Operations ---

    /**
     * Adds a new node right after the dummy head.
     */
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * Removes an existing node from the linked list.
     */
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /**
     * Moves an existing node to the head (most recently used position).
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * Pops the current tail (least recently used node).
     */
    private Node popTail() {
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}