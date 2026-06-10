package Lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K,V> {

    private class Node{
        K key;
        V value;
        Node prev;
        Node next;
        Node(K key,V value ){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K,Node> cache;
    private final ReentrantLock lock;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity){
        if(capacity < 0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.lock = new ReentrantLock();

        this.head = new Node(null,null);
        this.tail = new Node(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key){
        lock.lock();
        try {
            if(!cache.containsKey(key)){
                return null;
            }
            Node node = cache.get(key);
            moveToHead(node);
            return node.value;
        }finally {
            lock.unlock();
        }
    }

    public void put(K key, V value){
        lock.lock();
        try{
            if(cache.containsKey(key)){
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            }else{
                Node node = new Node(key,value);
                cache.put(key,node);
                addNode(node);
                if(cache.size() > capacity){
                    Node lruNode = popTail();
                    cache.remove(lruNode.key);
                }
            }
        }finally {
            lock.unlock();
        }
    }

    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    private Node popTail(){
        Node lruNode = tail.prev;
        removeNode(lruNode);
        return lruNode;
    }
}
