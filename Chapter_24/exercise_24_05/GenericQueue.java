package exercise_24_05;

import java.util.LinkedList;

public class GenericQueue<E> extends LinkedList<E>{
    
    public void enqueue(E e) {
        addLast(e);
    }
    
    public E dequeue() {
        return removeFirst();
    }
    
    public int getSize() {
        return size();
    }
    
    @Override
    public String toString() {
        return "Queue: " + super.toString();
    }
}
