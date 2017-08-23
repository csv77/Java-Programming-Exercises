package exercise_24_06;

import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;

public class Exercise_24_06 {

    public static void main(String[] args) {
        PriorityQueue<Rectangle> queue = new PriorityQueue(new GeometricObjectComparator());
        queue.enqueue(new Rectangle(10, 20));
        queue.enqueue(new Rectangle(30, 20));
        queue.enqueue(new Rectangle(20, 20));
        
        System.out.println(queue.dequeue());
    }
}
