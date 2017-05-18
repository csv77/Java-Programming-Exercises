package exercise_18_13;

import java.util.Scanner;

public class Exercise_18_13 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 8 integers: ");
        
        int[] array = new int[8];
        for(int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        
        System.out.println("The largest element of this array is " + maxArray(array));
    }
    
    public static int maxArray(int[] a) {
        return maxArray(a, 0, a[0]);
    }
    
    public static int maxArray(int[] a, int index, int max) {
        if(a.length == index) {
            return max;
        }
        else {
            if(a[index] > max) {
                max = a[index];
            }
        }
        return maxArray(a, index + 1, max); 
    }
    
}
