package com.LLD.Example.DesignHashMapImpl;

public class MyHashMap<K,V> {

    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    public Entry[] hashTable;

    public MyHashMap(){
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity){
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    class Entry<K,V>{
        public  K key;
        public V value;
        public  Entry next ;

        Entry(K k, V v ){
            key = k;
            value = v;
        }
    }

    public void put(K key, V value){
        int hashCode = key.hashCode()%hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null){
            Entry newNode = new Entry(key,value);
            hashTable[hashCode] = newNode;
        }else{
            Entry previousNode = node;
            while (node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key,value);
            previousNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        while (node != null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    final int tableSizeFor(int capacity){
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        // due to integer size we are stopping at 2^4=16 becase 2^5=32 which is bigger for integer
        return (n<0) ? 1 : (n >= MAXIMUM_CAPACITY) ? (MAXIMUM_CAPACITY) : (n + 1);
    }
    public static void main(String[] args) {
        MyHashMap<Integer,String> map = new MyHashMap<>(7);
        map.put(1,"hi");
        map.put(1,"my");
        map.put(1,"name");
        map.put(1,"is");
        map.put(1,"Ronak");
        map.put(1,"how");
        map.put(1,"are");
        map.put(1,"you");
        map.put(1,"friends");

        String value = map.get(8);
        System.out.println(value);
    }

}
