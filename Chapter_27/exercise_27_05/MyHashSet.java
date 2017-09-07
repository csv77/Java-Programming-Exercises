package exercise_27_05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<K> implements MySet<K>{
    MyHashMap<K, K> map;

    public MyHashSet() {
        map = new MyHashMap<>();
    }

    public MyHashSet(int initialCapacity) {
        map = new MyHashMap<>(initialCapacity);
    }
    
    public MyHashSet(int initialCapacity, float loadFactorThreshold) {
        map = new MyHashMap<>(initialCapacity, loadFactorThreshold);
    }
    
    @Override
    public void clear() {
        map.clear();
    }
    
    @Override
    public boolean contains(K e) {
        return map.containsKey(e);
    }

    @Override
    public boolean add(K e) {
        if(map.containsKey(e)) {
            return false;
        }
        else {
            map.put(e, e);
            return true;
        }
    }

    @Override
    public boolean remove(K e) {
        if(map.containsKey(e)) {
            map.remove(e);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
    
    @Override
    public int size() {
        return map.size();
    }
    
    public K get(K e) {
        return map.get(e);
    }
    
    @Override
    public Iterator<K> iterator() {
        return new MyHashSetIterator(this);
    }
    
    private class MyHashSetIterator implements Iterator<K> {
        private ArrayList<K> list;
        private int current = 0;
        private MyHashSet<K> set;

        public MyHashSetIterator(MyHashSet<K> set) {
            this.set = set;
            list = setToList();
        }
        
        @Override
        public boolean hasNext() {
            if(current < list.size()) {
                return true;
            }
            return false;
        }

        @Override
        public K next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            set.remove(list.get(current));
            list.remove(current);
        }
    }
    
    private ArrayList<K> setToList() {
        ArrayList<K> list = new ArrayList<>();
        Set<K> set = map.keySet();
        for(K k : set) {
            list.add(k);
        }
        return list;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        
        for(K k : map.values()) {
            if(k != null) {
                builder.append(k + ", ");
            } 
        }
        if(map.values().size() > 1) {
            builder = new StringBuilder(builder.substring(0, builder.length() - 2));
        }
        
        builder.append("]");
        return builder.toString();
    }
}
