package exercise_18_16;

import java.util.Scanner;

public class Exercise_18_16 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a text: ");
        
        String text = input.nextLine();
        
        System.out.println("The count of uppercase characters in this text " + countOfUpperCase(text.toCharArray()));
    }
    
    public static int countOfUpperCase(char[] text) {
        return countOfUpperCase(text, 0, 0);
    }
    
    public static int countOfUpperCase(char[] text, int index, int count) {
        if(index == text.length) {
            return count;
        }
        else {
            if(text[index] >= 'A' && text[index] <= 'Z') {
                count++;
            }
        }
        return countOfUpperCase(text, index + 1, count);
    }
    
}
