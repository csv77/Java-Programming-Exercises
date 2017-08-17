package exercise_23_12;

import java.util.ArrayList;

public class Exercise_23_12 {
    private static final int N = 7;
    
    public static void main(String[] args) {
        Integer[] list = new Integer[1000000];
        for(int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * Math.pow(10, N));
        }
        
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        radixSort(list, N);
        for(Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void radixSort(Integer[] list, int numberOfDigits) {
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < numberOfDigits; i++) {
            for(int j = 0; j < buckets.length; j++) {
                buckets[j].clear();
            }
            
            for(int j = 0; j < list.length; j++) {
                int temp = (list[j] / (int)(Math.pow(10, i))) % 10;
                buckets[temp].add(list[j]);
            }
            
            int k = 0;
            for(int j = 0; j < buckets.length; j++) {
                for(int n = 0; n < buckets[j].size(); n++) {
                    list[k++] = buckets[j].get(n);
                }
            }
        }
    }
}
