package exercise_27_05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet2<K> extends MyHashMap<K, K> implements MySet2<K>{
    
    @Override
    public void clear() {
        super.clear();
    }
    
    @Override
    public boolean contains(K e) {
        return super.containsKey(e);
    }

    @Override
    public boolean add(K e) {
        if(super.containsKey(e)) {
            return false;
        }
        else {
            super.put(e, e);
            return true;
        }
    }

    public boolean removeFromSet(K e) {
        if(super.containsKey(e)) {
            super.remove(e);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    
    @Override
    public int size() {
        return super.size();
    }
    
    @Override
    public K get(K e) {
        return super.get(e);
    }
    
    @Override
    public Iterator<K> iterator() {
        return new MyHashSetIterator(this);
    }

    private class MyHashSetIterator implements Iterator<K> {
        private ArrayList<K> list;
        private int current = 0;
        private MyHashSet2<K> set;

        public MyHashSetIterator(MyHashSet2<K> set) {
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
        Set<K> set = super.keySet();
        for(K k : set) {
            list.add(k);
        }
        return list;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        
        for(K k : super.values()) {
            if(k != null) {
                builder.append(k + ", ");
            } 
        }
        if(super.values().size() > 1) {
            builder = new StringBuilder(builder.substring(0, builder.length() - 2));
        }
        
        builder.append("]");
        return builder.toString();
    }
}
