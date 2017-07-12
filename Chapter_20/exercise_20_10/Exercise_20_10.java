package exercise_20_10;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Exercise_20_10 {

    public static void main(String[] args) {
        PriorityQueue<String> list1 = new PriorityQueue<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        PriorityQueue<String> list2 = new PriorityQueue<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
        
        PriorityQueue<String> union = new PriorityQueue<>(list1);
        for(String name : list2) {
            if(!union.contains(name)) {
                union.add(name);
            }
        }
        System.out.println(union);
        
        PriorityQueue<String> difference = new PriorityQueue<>(list1);
        difference.removeAll(list2);
        System.out.println(difference);
        
        PriorityQueue<String> intersection = new PriorityQueue<>(list1);
        intersection.retainAll(list2);
        System.out.println(intersection);
    }
}
