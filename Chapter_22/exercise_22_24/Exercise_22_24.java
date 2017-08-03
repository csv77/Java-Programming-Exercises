package exercise_22_24;

import java.util.ArrayList;

public class Exercise_22_24 {
    private static final int SIZE = 20;
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < SIZE; i++) {
            list.add((int)(Math.random() * 100));
        }
        System.out.println(list);
        
        System.out.println("The smallest number in the list: "
                + findSmallestNumber(list, 0, list.size() - 1));
    }
    
    public static int findSmallestNumber(ArrayList<Integer> list, int low, int high) {
        if(high - low == 1) {
            return Math.min(list.get(low), list.get(high));
        }
        else if(high - low == 0) {
            return list.get(low);
        }
        else {
            int halfsize = (high + low) / 2;
            return Math.min(findSmallestNumber(list, low, halfsize),
                    findSmallestNumber(list, halfsize + 1, high));
        }
    }
}
