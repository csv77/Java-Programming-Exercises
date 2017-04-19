package checkpassword;
import java.util.Scanner;

public class Checkpassword {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        if(enoughChar(password) && lettersDigits(password) && least2Digits(password)){
            System.out.println("Valid password");
        }
        else
            System.out.println("Invalid password");
    }
    
    public static boolean enoughChar(String pw){
        if(pw.length() < 8){
            return false;
        }
        else
            return true;
    }
    
    public static boolean lettersDigits(String pw){
        for(int i = 0; i < pw.length(); i++){
            if(!isLetterOrDigit(pw.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean least2Digits(String pw){
        int numberDigits = 0;
        for(int i = 0; i < pw.length(); i++){
            if(pw.charAt(i) >= '0' && pw.charAt(i) <= '9'){
                numberDigits++;
            }
        }
        if(numberDigits >= 2){
            return true;
        }
        else
            return false;
    }
    
    public static boolean isLetterOrDigit(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
            return true;
        }
        else
            return false;
    }
}
