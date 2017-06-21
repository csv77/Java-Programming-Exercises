package exercise_18_17;

import java.util.Scanner;

public class Exercise_18_17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a string: ");
        String text = input.next();
        System.out.print("Type in a character to count: ");
        char letter = input.next().charAt(0);
        
        System.out.println(count(text.toCharArray(), letter));
    }
    
    public static int count(char[] chars, char a) {
        return count(chars, a, chars.length - 1);
    }
    
    public static int count(char[] chars, char a, int high) {
        int n = (chars[high] == a) ? 1 : 0;
        if(high == 0) {
            return n;
        }
        else {
            return n + count(chars, a, high - 1);
        }
    }
    
}
