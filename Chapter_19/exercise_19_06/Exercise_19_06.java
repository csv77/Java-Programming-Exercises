package exercise_19_06;

public class Exercise_19_06 {

    public static void main(String[] args) {
        Integer[][] integers =  new Integer[10][10];
        
        for(int i = 0; i < integers.length; i++) {
            for(int j = 0; j < integers[i].length; j++) {
                integers[i][j] = i + j;
            }
        }
        
        System.out.println("The max is: " + max(integers));
    }
    
    public static <E extends Comparable<E>> E max(E[][] list) {
        E max = list[0][0];
        for(int i = 0; i < list.length; i++) {
            for(int j = 0; j < list[i].length; j++) {
                if(max.compareTo(list[i][j]) < 0) {
                    max = list[i][j];
                }
            }
        }
        return max;
    }
    
}
