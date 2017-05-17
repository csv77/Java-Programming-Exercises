package exercise_18_07;

import java.util.Scanner;

public class Exercise_18_07 {
    public static int i = 0;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();
        System.out.println("The Fibonacci number at index " + index + " is " + fib(index));
        System.out.println("The fib method was invoked " + i + " times");
    }
    
    public static long fib(long index) {
        i++;
        if(index == 0) {
            return 0;
        }
        else if(index == 1) {
            return 1;
        }
        else {
            return fib(index - 1) + fib(index - 2);
        }
    }
    
}
