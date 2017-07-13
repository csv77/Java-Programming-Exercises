package exercise_20_12;

import java.util.PriorityQueue;

public class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        MyPriorityQueue<E> myPriorityQueue = new MyPriorityQueue<>();
        myPriorityQueue.addAll((MyPriorityQueue<E>)super.clone());
        return myPriorityQueue;
    }
}
