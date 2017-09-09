package exercise_27_10;

import java.util.ArrayList;

public class Exercise_27_10 {

    public static void main(String[] args) {
        MyArrayList<Double> list = new MyArrayList<>();
        MyHashSet<Double> set = new MyHashSet<>();
        
        for(int i = 0; i < 1000000; i++) {
            double element = (Math.random() * 1000000);
            list.add(element);
            set.add(element);
        }
        
        ArrayList<Double> values = new ArrayList<>();
        
        for(int i = 0; i < 1000000; i++) {
            values.add(Math.random() * 2000000);
        }
        
        long startTime = System.currentTimeMillis();
        
        for(Double value : values) {
            list.contains(value);
        }
        
        System.out.println("Test time for MyArrayList (ms): " + (System.currentTimeMillis() - startTime));
        
        startTime = System.currentTimeMillis();
        
        for(Double value : values) {
            set.contains(value);
        }
        
        System.out.println("Test time for MyHashSet (ms): " + (System.currentTimeMillis() - startTime));
    }
}
