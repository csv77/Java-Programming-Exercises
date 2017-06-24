package exercise_18_22;

import java.util.Scanner;

public class Exercise_18_22 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal: ");
        int value = input.nextInt();
        System.out.println("The hex representation: " + dec2Hex(value));
    }
    
    public static String dec2Hex(int value) {
        if(value <= 15) {
            return hexChar(value);
        }
        else {
            String hex = hexChar(value % 16);
            value /= 16;
            return dec2Hex(value) + hex;
        }
    }
    
    public static String hexChar(int value) {
        if(value % 16 <= 9) {
            return value + "";
        }
        else if(value % 16 > 9 && value % 16 < 16){
            char hex = (char)('A' + (value % 16 - 10));
            return hex + "";
        }
        return "not valid number";
    }
    
}
