package exercise_18_09;

import java.util.Scanner;

public class Exercise_18_09 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a string: ");
        String text = input.nextLine();
        
        reverseDisplay(text);
    }
    
    public static void reverseDisplay(String value) {
        if(value.length() == 1) {
            System.out.println(value);
        }
        else {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
    
}
