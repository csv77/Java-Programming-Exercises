package exercise_18_02;

import java.util.Scanner;

public class Exercise_18_02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();
        
        System.out.println("The fibonacci number at index " + index + " is " + fib(index));
    }
    
    public static long fib(long index) {
        if(index == 0) {
            return 0;
        }
        else if(index == 1) {
            return 1;
        }
        
        long fib0 = 0;
        long fib1 = 1;
        long currentFib = fib0 + fib1;
        
        for(int i = 2; i <= index; i++) {
            currentFib = fib0 + fib1;
            fib0 = fib1;
            fib1 = currentFib;
        }
        return currentFib;
    }
}
