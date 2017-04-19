package hex2dec;

import java.util.Scanner;

public class Hex2Dec {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        try {
            System.out.println("The decimal value for hex number "
             + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int hexToDecimal(String hex) throws NumberFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if(!(hexChar >= 'A' && hexChar <= 'F') && !(hexChar >= '0' && hexChar <= '9')){
                throw new NumberFormatException("Not a hex number.");
            }
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    
    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
        return 10 + ch - 'A';
        else // ch is '0', '1', ..., or '9'
        return ch - '0';
    }
}
