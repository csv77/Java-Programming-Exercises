package exercise_24_06;

import exercise_23_09.Heap;
import java.util.Comparator;

public class PriorityQueue<E> {
    private Heap<E> heap;
    
    public PriorityQueue(Comparator<? super E> comparator) {
        heap = new Heap<E>(comparator);
    }
    
    public void enqueue(E newObject) {
        heap.add(newObject);
    }
    
    public E dequeue() {
        return heap.remove();
    }
    
    public int getSize() {
        return heap.getSize();
    }
}
