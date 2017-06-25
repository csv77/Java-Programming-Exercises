package exercise_18_25;

import java.util.Scanner;

public class Exercise_18_25 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.next();
        displayPermutation(s);
    }
    
    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }
    
    public static void displayPermutation(String s1, String s2) {
        if(s2.length() == 0) {
            System.out.println(s1);
        }
        else {
            for(int i = 0; i < s2.length(); i++) {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }
    
}
