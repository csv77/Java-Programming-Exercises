package exercise_18_10;

import java.util.Scanner;

public class Exercise_18_10 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a string: ");
        String text = input.nextLine();
        System.out.print("Type in a character to count: ");
        char letter = input.nextLine().charAt(0);
        
        System.out.println(count(text, letter));
    }
    
    public static int count(String str, char a) {
        if(str.length() == 1) {
            return str.charAt(0) == a ? 1 : 0;
        }
        else {
            return str.charAt(str.length() - 1) == a ? 1 + count(str.substring(0, str.length() - 1), a) :
                    0 + count(str.substring(0, str.length() - 1), a);
        }
    }
    
}
