package exercise_19_02;

import java.util.ArrayList;

public class GenericStack<E> extends ArrayList<E>{
    public int getSize() {
        return this.size();
    }
    
    public E peek() {
        return this.get(this.size()- 1);
    }
    
    public void push(E o) {
        this.add(o);
    }
    
    public E pop() {
        E o = this.get(this.size() - 1);
        this.remove(this.size() - 1);
        return o;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public String toString() {
        String stack = "";
        for(int i = 0; i < this.size(); i++) {
            stack += this.get(i) + " ";
        }
        return "stack: " + stack;
    }
}
