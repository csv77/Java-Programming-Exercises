package exercise_18_24;

import java.util.Scanner;

public class Exercise_18_24 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hexadecimal: ");
        String hex = input.next();
        System.out.println("The decimal: " + hex2Dec(hex.toUpperCase()));
    }
    
    public static int hex2Dec(String hexString) {
        if(hexString.length() == 1) {
            return hexChar(hexString.charAt(0));
        }
        else {
            return (int)Math.pow(16, hexString.length() - 1) * hexChar(hexString.charAt(0)) + hex2Dec(hexString.substring(1));
        }
        
    }
    
    public static int hexChar(char hexChar) {
        if(hexChar >= '0' && hexChar <= '9') {
            return hexChar - '0';
        }
        else {
            return hexChar - 'A' + 10;
        }
    }
    
}
