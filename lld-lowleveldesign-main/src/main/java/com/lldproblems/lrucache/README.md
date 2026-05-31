# LRU Cache Implementation in Java

This repository contains a Low-Level Design (LLD) implementation of a **Least Recently Used (LRU) Cache** in Java.

An LRU Cache is a data structure that stores a limited number of items. When the cache reaches its capacity, it automatically evicts the item that has not been accessed for the longest period of time to make room for new items.

## 🏗️ Architecture & Data Structures

To achieve optimal performance, this LRU Cache is built using two core data structures:

1. **HashMap (`Map<K, Node>`)**: Provides **O(1)** time complexity for locating nodes by their keys.
2. **Doubly Linked List (`Node`)**: Maintains the history of usage. The most recently used items are kept near the `head`, while the least recently used items naturally fall toward the `tail`. A doubly linked list is used so that node removal (even from the middle of the list) happens in **O(1)** time.

### Dummy Nodes
The implementation utilizes a **dummy head** and **dummy tail** node. This elegant design pattern eliminates edge cases (like checking for null pointers when the list is empty or has only one node), making the insertion and removal logic much cleaner and less prone to errors.

## ⚡ Complexity

* **Time Complexity**:
    * `get(key)`: **O(1)**
    * `put(key, value)`: **O(1)**
* **Space Complexity**: **O(capacity)** where capacity is the maximum number of items the cache can hold.

## 🚀 Usage

```java
// Initialize a cache with a capacity of 2
LRUCache<Integer, String> cache = new LRUCache<>(2);

cache.put(1, "Data 1"); // Cache: [1]
cache.put(2, "Data 2"); // Cache: [2, 1]

System.out.println(cache.get(1)); // Returns "Data 1". Cache becomes: [1, 2]

cache.put(3, "Data 3"); // Evicts key 2. Cache becomes: [3, 1]

System.out.println(cache.get(2)); // Returns null (not found)