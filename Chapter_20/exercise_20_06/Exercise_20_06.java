package exercise_20_06;

import java.util.Iterator;
import java.util.LinkedList;

public class Exercise_20_06 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 500000; i++) {
            list.add(i);
        }
        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Iterator duration (ms): " + (endTime - startTime));
        
        startTime = System.currentTimeMillis();
        for(int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Get(i) duration (ms): " + (endTime - startTime));
    }
    
}
