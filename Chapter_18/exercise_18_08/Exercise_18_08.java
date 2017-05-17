package exercise_18_08;

import java.util.Scanner;

public class Exercise_18_08 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int value = input.nextInt();
        reverseDisplay(value);
    }
    
    public static void reverseDisplay(int value) {
        if(value < 10) {
            System.out.println(value % 10);
        }
        else {
            System.out.print(value % 10);
            reverseDisplay(value / 10);
        }
        
    }
    
}
