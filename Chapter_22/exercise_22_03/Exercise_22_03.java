package exercise_22_03;

import java.util.Scanner;

public class Exercise_22_03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string s1: ");
        String s1 = input.nextLine();
        System.out.print("Enter a string s2: ");
        String s2 = input.nextLine();
        
        int count = 0;
        int index = -1;
        
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0) && count == 0) {
                index = i;
                count++;
            }
            else if(s1.charAt(i) == s2.charAt(count)) {
                count++;
            }
            else {
                count = 0;
                index = -1;
            }
            
            if(count == s2.length()) {
                break;
            }
        }
        
        if(index >= 0) {
            System.out.println("matched at index " + index);
        }
        else {
            System.out.println("Any match can be found");
        }
    }
    
}
