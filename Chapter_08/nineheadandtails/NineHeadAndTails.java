package nineheadandtails;
import java.util.Scanner;

public class NineHeadAndTails {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.print("Enter a number between 0 and 511: ");
        number = input.nextInt();
        displayMatrix(createCharArray(convertToBinary(number)));
    }
    
    public static String convertToBinary(int n){
        String binaryNumber;
        binaryNumber = Integer.toBinaryString(n);
        for(int i = 0; binaryNumber.length() != 9; i++){
            binaryNumber = "0" + binaryNumber;
        }
        return binaryNumber;
    }
    
    public static char[][] createCharArray(String number){
        char[][] headAndNail = new char[3][3];
        int k = 0;
        for(int i = 0; i < headAndNail.length; i++){
            for(int j = 0; j < headAndNail[i].length; j++){
                if(number.charAt(k) == '0'){
                    headAndNail[i][j] = 'H';
                }
                else if(number.charAt(k) == '1'){
                    headAndNail[i][j] = 'T';
                }
                k++;
            }
        }
        return headAndNail;
    }
    
    public static void displayMatrix(char[][] ch){
        for(int i = 0; i < ch.length; i++){
            for(int j = 0; j < ch[i].length; j++){
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
    }
}
