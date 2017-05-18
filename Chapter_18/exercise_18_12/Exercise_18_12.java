package exercise_18_12;

import java.util.Scanner;

public class Exercise_18_12 {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.print("Type in a string: ");
        String text = input.nextLine();
        
        reverseDisplay(text); 
    }
    
    public static void reverseDisplay(String value) {
        reverseDisplay(value, value.length());
    }
    
    public static void reverseDisplay(String value, int high) {
        if(high == 1) {
            System.out.println(value.charAt(0));
        }
        else {
            System.out.print(value.charAt(high - 1));
            reverseDisplay(value, high - 1);
        }
    }
    
}
