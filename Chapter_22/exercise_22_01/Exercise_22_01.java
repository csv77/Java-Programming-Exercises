package exercise_22_01;

import java.util.Scanner;

public class Exercise_22_01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = input.next();
        
        int length = 1;
        int maxLength = 1;
        int maxIndex = 0;
        
        for(int i = 1; i < string.length(); i++) {
            if(string.charAt(i - 1) <= string.charAt(i)) {
                length++;
            }
            else {
                length = 1;
           }
            if(maxLength < length) {
                    maxLength = length;
                    maxIndex = i - maxLength + 1;
            }
        }
        
        System.out.println(string.substring(maxIndex, maxIndex + maxLength));
    }
}
