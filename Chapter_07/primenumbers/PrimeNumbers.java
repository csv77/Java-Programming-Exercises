package primenumbers;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] primes = new int[50];
        primes(primes);
        System.out.print("Enter a number to check is it is prime: ");
        int number = input.nextInt();
        boolean isPrime2 = true;
        for(int i = 0; primes[i] < (int)Math.sqrt(number) && i < 50 && isPrime2; i++){
            if(number % primes[i] == 0){
                isPrime2 = false;
            }
        }
        if(isPrime2){
            System.out.println(number + " is prime");
        }
        else{
            System.out.println(number + " is not prime");
        }
    }
    
    public static void primes(int[] primes){
        int count = 0;
        int number = 2;
        while(count < 50){
            if(isPrime(number)){
                primes[count] = number;
                count++;
            }
            number++;
        }
    }
    
    public static boolean isPrime(int number){
        boolean isPrime = true;
            for(int divisor = 2; divisor <= number / 2 && isPrime; divisor++){
                if(number % divisor == 0){
                    isPrime = false;
                }
            }
        return isPrime;
    }
    
}
