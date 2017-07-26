package exercise_22_02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise_22_02 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = input.nextLine();
        
        LinkedList<Character> maxSubstring = new LinkedList<>();
        
        for(int i = 0; i < string.length(); i++) {
            LinkedList<Character> substring = new LinkedList<>(Arrays.asList(string.charAt(i)));
            for(int j = i + 1; j < string.length(); j++) {
                if(substring.getLast() <= string.charAt(j)) {
                    substring.add(string.charAt(j));
                }
            }
            
            if(maxSubstring.size()< substring.size()) {
                maxSubstring.clear();
                maxSubstring.addAll(substring);
            }
            substring.clear();
        }
        
        for(char ch : maxSubstring) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
