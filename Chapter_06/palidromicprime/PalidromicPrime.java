package palidromicprime;
import java.util.Scanner;

public class PalidromicPrime {

    public static void main(String[] args) {
        printPrimePalindrome();
    }
    
    public static boolean isPrime(int number){
        for(int i = 2; i <= number / 2; i++){
            if(number % i ==0){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome(int number){
        int reverse = 0;
        int temp = number;
        while(temp != 0){
            reverse += temp % 10;
            temp /= 10;
            if(temp != 0){
                reverse *= 10;
            }
        }
        if(number == reverse){
            return true;
        }
        else
            return false;
    }
    
    public static void printPrimePalindrome(){
        int count = 0;
        int i = 2;
        while(count < 100){
            if(isPrime(i) && isPalindrome(i)){
                count++;
                if(count % 10 == 0){
                    System.out.printf("%5d \n", i);
                }
                else{
                    System.out.printf("%5d ", i);
                }
            }
            i++;
        }
    }
}
