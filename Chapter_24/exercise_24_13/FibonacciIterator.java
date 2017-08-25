package exercise_24_13;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer>{
    private int limit;
    private int current = 1;
    private int previous = -1;

    public FibonacciIterator(int limit) {
        this.limit = limit;
    }
    
    @Override
    public boolean hasNext() {
        int temp = current;
        current = current + previous;
        previous = temp;
        if(current <= limit) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Integer next() {
        return current;
    }
    
    
    
}
