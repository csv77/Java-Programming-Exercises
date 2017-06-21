package exercise_18_15;

import java.util.Scanner;

public class Exercise_18_15 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a string: ");
        String text = input.next();
        System.out.print("Type in a character to count: ");
        char letter = input.next().charAt(0);
        
        System.out.println(count(text, letter));
    }
    
    public static int count(String str, char a) {
        return count(str, a, str.length() - 1);
    }
    
    public static int count(String str, char a, int high) {
        int n = (str.charAt(high) == a) ? 1 : 0;
        if(high == 0) {
            return n;
        }
        else {
            return n + count(str, a, high - 1);
        }
    }
    
    
}
