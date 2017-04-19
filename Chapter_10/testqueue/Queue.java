package testqueue;

public class Queue {
    private int[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;
    
    Queue(){
        this(DEFAULT_CAPACITY);
    }
    
    Queue(int capacity){
        elements = new int[capacity];
    }
    
    public void enqueue(int v){
        if(size >= elements.length){
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = v;
    }
    
    public int dequeue(){
        int element = elements[0];
        int[] temp = new int[elements.length];
        System.arraycopy(elements, 1, temp, 0, size);
        elements = temp;
        size--;
        return element;
    }
    
    public boolean empty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
}
