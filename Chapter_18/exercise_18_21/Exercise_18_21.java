package exercise_18_21;

import java.util.Scanner;

public class Exercise_18_21 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal: ");
        int value = input.nextInt();
        System.out.println("The binary representation: " + dec2Bin(value));
    }
    
    public static String dec2Bin(int value) {
        if(value <= 1) {
            return Integer.toString(value % 2);
        }
        else {
            String bit = Integer.toString(value % 2);
            value /= 2;
            return dec2Bin(value) + bit;
        }
        
    }
    
}
