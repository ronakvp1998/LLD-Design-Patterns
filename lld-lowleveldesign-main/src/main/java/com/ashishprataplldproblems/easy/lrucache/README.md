# LRU Cache Implementation in Java

## 1. Problem Statement
The goal is to design and implement a Least Recently Used (LRU) Cache. A cache is a constrained memory storage system. When the cache is full and a new item needs to be added, the system must evict the item that hasn't been accessed (either retrieved or updated) for the longest time to make room for the new element. The objective is to achieve `O(1)` time complexity for both data retrieval (`get`) and data insertion/updating (`put`).

## 2. Requirements and Scope
* **Functional Requirements:**
  * `put(key, value)`: Insert a new key-value pair into the cache. If the key already exists, update its value. If the cache reaches its capacity, evict the least recently used item before inserting the new one.
  * `get(key)`: Retrieve the value associated with the key. If the key is not found, return `null` (or a default value). Accessing an item marks it as the most recently used.
* **Non-Functional Requirements:**
  * **Performance:** Both `get` and `put` operations must execute in `O(1)` time complexity.
  * **Space Complexity:** Should be `O(capacity)`.
  * **Concurrency:** The cache must be thread-safe to support concurrent access in a multi-threaded environment.
* **Scope/Out of Scope:**
  * **Out of scope:** Persistent storage (this is strictly an in-memory cache).
  * **Out of scope:** Expiration time (TTL) for cache entries.

## 3. Design and System Flow
To achieve `O(1)` time complexity for both operations, we combine two data structures:
1. **HashMap (`Map<K, Node>`)**: Provides `O(1)` access time to locate a node based on its key.
2. **Doubly Linked List**: Maintains the recency of cache items.
  * The **head** represents the *most recently used* (MRU) side.
  * The **tail** represents the *least recently used* (LRU) side.
  * It allows `O(1)` additions (at the head) and removals (from any position, given we have the node reference from the HashMap).

**Execution Flow:**
* **`get(key)` Flow:**
  1. Acquire lock.
  2. Check the HashMap. If the key doesn't exist, return `null`.
  3. If it exists, retrieve the `Node`.
  4. Move the `Node` to the front (head) of the doubly linked list, as it was just accessed.
  5. Release lock and return the `Node`'s value.
* **`put(key, value)` Flow:**
  1. Acquire lock.
  2. Check the HashMap. If the key exists, update the `Node`'s value and move it to the front.
  3. If the key doesn't exist, create a new `Node`.
  4. Insert the new `Node` into the HashMap and add it to the front of the linked list.
  5. Check if the cache size exceeds its `capacity`. If so, remove the node immediately before the tail (the LRU node) from the linked list, and remove its key from the HashMap.
  6. Release lock.

## 4. Class-Level Explanation

### `LRUCache<K, V>`
* **Name & Responsibility:** The main orchestrator class responsible for managing the cache state, including the HashMap and the Doubly Linked List operations in a thread-safe manner.
* **Key Attributes:**
  * `capacity`: The maximum number of elements the cache can hold.
  * `cache` (`Map<K, Node>`): The hash map for `O(1)` key lookups.
  * `lock` (`ReentrantLock`): Ensures mutually exclusive access to the cache map and list.
  * `head` (`Node`): A dummy node representing the front of the list (most recently used).
  * `tail` (`Node`): A dummy node representing the end of the list (least recently used).
* **Key Methods:**
  * `get(K key)`: Retrieves value and triggers `moveToHead(node)`.
  * `put(K key, V value)`: Updates/adds nodes, triggers eviction via `popTail()` if capacity is reached.
  * `addNode(Node node)`: Helper to insert a node immediately after the dummy `head`.
  * `removeNode(Node node)`: Helper to detach a node from the linked list by updating adjacent pointers.
  * `moveToHead(Node node)`: Combines `removeNode` and `addNode`.
  * `popTail()`: Identifies and removes the node just before the dummy `tail`.
* **Relationships:** Contains (Composition) the HashMap and the doubly linked list Nodes.

### `Node` (Inner Class)
* **Name & Responsibility:** Represents an individual item in the cache. It acts as both a value container for the HashMap and a node for the doubly linked list. Keeping this as a private inner class encapsulates the data structure.
* **Key Attributes:**
  * `key`: Stored so we can easily remove the entry from the HashMap during eviction (when we pop the tail).
  * `value`: The cached data.
  * `prev`: Pointer to the previous node in the list.
  * `next`: Pointer to the next node in the list.
* **Relationships:** Doubly linked to other `Node` instances.

## 5. Design Patterns Implemented
* **Pattern Name:** Dummy Head/Tail (Sentinel Nodes) Pattern.
* **Why it was used:** In a standard doubly linked list, adding or removing nodes requires numerous `null` checks to handle edge cases (e.g., an empty list, a list with one item, adding to the extreme front or back).
* **How it was implemented:** We initialize the `LRUCache` with `head` and `tail` nodes that never contain actual data and are never removed. `head.next` points to `tail` and `tail.prev` points to `head`. All real data nodes are inserted strictly *between* these two dummy nodes. This guarantees that every real node always has a valid `prev` and `next`, completely eliminating `null` checks during insertions and deletions.

## 6. Assumptions & Trade-offs (Crucial for Interviews)
* **Design Decision - Thread-Safe Implementation:** The cache uses a `ReentrantLock` around `put` and `get` operations to ensure thread safety when accessing the internal `HashMap` and manipulating the doubly linked list pointers. Alternatively, a `ConcurrentHashMap` combined with concurrent list management could have been used, but explicit locking simplifies node repositioning and ensures atomic updates across both data structures.
* **Assumption - In-Memory:** The system relies entirely on JVM heap memory.
* **Trade-off - Memory Overhead:** Storing data in a doubly linked list uses more memory than a single linked list or a simple array because of the two extra object references (`prev` and `next`) per element. We trade memory for `O(1)` deletion time.
* **Trade-off - Key Storage in Node:** We store the `key` inside the `Node` (in addition to the value). This introduces a small memory redundancy but is crucial for `O(1)` eviction. When we drop the LRU item from the linked list (tail), we need its `key` to delete the corresponding entry from the HashMap.

## 7. Step-by-Step Implementation Guide (Revision Strategy)
To reconstruct this from scratch:

* **Step 1: Define the `Node` class.** It must hold `key`, `value`, `prev`, and `next`. (Remember: store the `key` to facilitate map deletion later!).
* **Step 2: Initialize `LRUCache` state.** Create the `capacity`, `HashMap`, `ReentrantLock`, and the `head`/`tail` dummy nodes. Link `head` to `tail` initially in the constructor.
* **Step 3: Build the fundamental linked list helper methods.** Implement `addNode(node)` (always adds right after `head`) and `removeNode(node)` (detaches a node by wiring its neighbors together).
* **Step 4: Implement higher-level helpers.** Build `moveToHead(node)` (calls `removeNode` then `addNode`) and `popTail()` (calls `removeNode` on `tail.prev` and returns it).
* **Step 5: Stitch it all together with thread safety in `get` and `put`.**
  * Wrap the entire method logic inside `lock.lock()` and a `try-finally` block containing `lock.unlock()`.
  * In `get`: Look up in map -> return `null` if absent -> call `moveToHead` -> return value.
  * In `put`:
    * If present: update value -> `moveToHead`.
    * If absent: create node -> add to map -> `addNode` -> if size > capacity, call `popTail` -> remove returned node's key from map.