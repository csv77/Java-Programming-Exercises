package exercise_18_03;

import java.util.Scanner;

public class Exercise_18_03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer1: ");
        int m = input.nextInt();
        System.out.print("Enter integer2: ");
        int n = input.nextInt();
        
        System.out.println("The greatest common divisor of " + m + " and " +
                n + " is: " + gcd(m, n));
        
    }
    
    public static int gcd(int m, int n) {
        if(m % n == 0) {
            return n;
        }
        else {
            return gcd(n, m % n);
        }
    }
    
}
