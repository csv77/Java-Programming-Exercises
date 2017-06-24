package exercise_18_23;

import java.util.Scanner;

public class Exercise_18_23 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary: ");
        boolean isBinary = false;
        String binary = input.next();
        while(!isBinary) {
            isBinary = true;
            for(int i = 0; i < binary.length(); i++) {
                if(binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                    isBinary = false;
                }
            }
            if(!isBinary) {
                binary = input.next();
            }
        }
        
        System.out.println("The decimal: " + bin2Dec(binary));
    }
    
    public static int bin2Dec(String binaryString) {
        if(binaryString.length() == 1) {
            return Integer.valueOf(binaryString);
        }
        else {
            return (int)Math.pow(2, binaryString.length() - 1) * Integer.valueOf(binaryString.substring(0, 1)) + bin2Dec(binaryString.substring(1));
        }
        
    }
    
    
}
