package binaryconvert;

import java.util.Scanner;

public class BinaryConvert {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String bin = input.next();
        try{
            System.out.println(bin2Dec(bin));
        }
        catch(BinaryFormatException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public static int bin2Dec(String binaryString) throws BinaryFormatException{
        int decimal = 0;
        for(int i = 0; i < binaryString.length(); i++){
            if(binaryString.charAt(i) < '0' || binaryString.charAt(i) > '1'){
                throw new BinaryFormatException(binaryString);
            }
            decimal += Integer.parseInt(String.valueOf(binaryString.charAt(i))) * Math.pow(2, binaryString.length() - (i + 1));
        }
        return decimal;
    }
    
}
