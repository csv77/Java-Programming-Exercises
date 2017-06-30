package exercise_19_07;

import java.util.Arrays;

public class Exercise_19_07 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        
        for(int i = 0; i < integers.length; i++) {
            integers[i] = i * 2;
        }
        
        System.out.println(binarySearch(integers, 5));
        System.out.println(binarySearch(integers, 6));
    }
    
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        Arrays.sort(list);
        int lowIndex = 0;
        int highIndex = list.length - 1;
        while(lowIndex <= highIndex) {
            int i = (lowIndex + highIndex) / 2;
            if(list[i].compareTo(key) == 0){
                return i;
            }
            else if(list[i].compareTo(key) > 0) {
                highIndex = i - 1;
            }
            else {
                lowIndex = i + 1;
            }
        }
        return - lowIndex - 1;
    }
}
