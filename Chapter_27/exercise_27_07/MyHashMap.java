package exercise_27_07;

import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    private static int MAXIMUM_CAPACITY = 1 << 30; 

    private int capacity;

    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f; 

    private float loadFactorThreshold; 

    private int size = 0; 

    LinkedList<MyMap.Entry<K,V>>[] table;

    public MyHashMap() {  
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);    
    }

    public MyHashMap(int initialCapacity) { 
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);    
    }

    public MyHashMap(int initialCapacity, float loadFactorThreshold) { 
        if(initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else
            this.capacity = initialCapacity;

        this.loadFactorThreshold = loadFactorThreshold;    
        table = new LinkedList[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public float getLoadFactorThreshold() {
        return loadFactorThreshold;
    }

    @Override /** Remove all of the entries from this map */ 
    public void clear() {
        size = 0;
        removeEntries();
    }

    @Override /** Return true if the specified key is in the map */
    public boolean containsKey(K key) {    
        if(get(key) != null)
            return true;
        else
            return false;
    }

    @Override /** Return true if this map contains the value */ 
    public boolean containsValue(V value) {
        for(int i = 0; i < capacity; i++) {
            if(table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i]; 
                for(Entry<K, V> entry: bucket)
                    if(entry.getValue().equals(value)) 
                        return true;
            }
        }

        return false;
    }

    @Override /** Return a set of entries in the map */
    public java.util.Set<MyMap.Entry<K,V>> entrySet() {
        java.util.Set<MyMap.Entry<K, V>> set = new java.util.HashSet<>();

        for(int i = 0; i < capacity; i++) {
            if(table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i]; 
                for(Entry<K, V> entry: bucket)
                    set.add(entry); 
            }
        }

        return set;
    }

    @Override /** Return the value that matches the specified key */
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if(table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
            for(Entry<K, V> entry: bucket)
                if(entry.getKey().equals(key)) 
                    return entry.getValue();
        }

        return null;
    }

    @Override /** Return true if this map contains no entries */
    public boolean isEmpty() {
        return size == 0;
    }  

    @Override /** Return a set consisting of the keys in this map */
    public java.util.Set<K> keySet() {
        java.util.Set<K> set = new java.util.HashSet<K>();

        for(int i = 0; i < capacity; i++) {
            if(table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i]; 
                for(Entry<K, V> entry: bucket)
                    set.add(entry.getKey()); 
            }
        }

        return set;
    }

    @Override /** Add an entry (key, value) into the map */
    public V put(K key, V value) {
        if(get(key) != null) { // The key is already in the map
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
            for(Entry<K, V> entry: bucket)
                if(entry.getKey().equals(key)) {
                    V oldValue = entry.getValue();
                    entry.value = value; 
                    return oldValue;
                }
        }

        if(size >= capacity * loadFactorThreshold) {
            if(capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }

        int bucketIndex = hash(key.hashCode());

        if(table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<Entry<K, V>>();
        }

        table[bucketIndex].add(new MyMap.Entry<K, V>(key, value));

        size++; // Increase size

        return value;  
    } 

    @Override /** Remove the entries for the specified key */
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());

        if(table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex]; 
            for(Entry<K, V> entry: bucket)
                if(entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--; // Decrease size
                    break; // Remove just one entry that matches the key
                }
        }
    }

    @Override /** Return the number of entries in this map */
    public int size() {
        return size;
    }

    @Override /** Return a set consisting of the values in this map */
    public java.util.Set<V> values() {
        java.util.Set<V> set = new java.util.HashSet<>();

        for(int i = 0; i < capacity; i++) {
            if(table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i]; 
                for(Entry<K, V> entry: bucket)
                    set.add(entry.getValue()); 
            }
        }

        return set;
    }

    /** Hash function */
    private int hash(int hashCode) {
        return hashCode % capacity;
//        return supplementalHash(hashCode) & (capacity - 1);
    }

    /** Ensure the hashing is evenly distributed */
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /** Return a power of 2 for initialCapacity */
    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while(capacity < initialCapacity) {
            capacity <<= 1;
        }

        return capacity;
    }

    /** Remove all entries from each bucket */
    private void removeEntries() {
        for(int i = 0; i < capacity; i++) {
            if(table[i] != null) {
                table[i].clear();
            }
        }
    }

    /** Rehash the map */
    private void rehash() {
        java.util.Set<Entry<K, V>> set = entrySet(); // Get entries
        capacity <<= 1; // Double capacity    
        table = new LinkedList[capacity]; // Create a new hash table
        size = 0; // Reset size to 0

        for(Entry<K, V> entry: set) {
            put(entry.getKey(), entry.getValue()); // Store to new table
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for(int i = 0; i < capacity; i++) {
            if(table[i] != null && table[i].size() > 0) 
                for(Entry<K, V> entry: table[i])
                    builder.append(entry);
        }

        builder.append("]");
        return builder.toString();
    }
}