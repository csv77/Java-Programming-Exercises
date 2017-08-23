package exercise_24_06;

import exercise_23_09.Heap;
import java.util.Comparator;

public class PriorityQueue<E> {
    private Heap<E> heap;
    private Comparator<? super E> comparator;

    public PriorityQueue(Comparator<? super E> comparator) {
        this.comparator = comparator;
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
