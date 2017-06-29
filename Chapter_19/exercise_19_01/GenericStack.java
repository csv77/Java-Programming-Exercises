package exercise_19_01;

public class GenericStack<E> {
    private E[] list = (E[])new Object[10];
    private int size = 0;
    
    public int getSize() {
        return size;
    }
    
    public E peek() {
        if(size == 0) {
            return null;
        }
        else {
            return list[size - 1];
        }
    }
    
    public void push(E o) {
        if(size >= list.length) {
            E[] list2 = (E[])new Object[2 * list.length];
            System.arraycopy(list, 0, list2, 0, list.length);
            list = list2;
        }
        list[size++] = o;
    }
    
    public E pop() {
        if(size == 0) {
            return null;
        }
        else {
            E o = list[--size];
            return o;
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
    
}
