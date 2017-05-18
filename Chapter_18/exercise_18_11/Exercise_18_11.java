package exercise_18_11;

import java.util.Scanner;

public class Exercise_18_11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long i = input.nextLong();
        
        System.out.println("The sum of the digits in " + i + " is " + sumDigits(i));
    }
    
    public static int sumDigits(long n) {
        if(n < 10) {
            return (int)n;
        }
        else {
            return (int)(n % 10) + sumDigits(n / 10);
        }
        
    }
}
