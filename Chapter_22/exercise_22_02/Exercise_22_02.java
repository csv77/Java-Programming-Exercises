package exercise_22_02;

import java.util.Scanner;

public class Exercise_22_02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = input.next();
        
        char[] array = string.toCharArray();
        String substring = "" + array[0];
        
        for(int i = 1; i < array.length; i++) {
            if(substring.charAt(substring.length() - 1) <= array[i]) {
                substring += "" + array[i];
            }
        }
        
        System.out.println(substring);
    }
}
