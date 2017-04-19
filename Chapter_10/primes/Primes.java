package primes;
import testprimefactors.*;

public class Primes {

    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        for(int i = 0; i <= 120; i++){
            if(isPrime(i)){
                stack.push(i);
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    
    public static boolean isPrime(int number){
        if(number == 1 || number == 0){
            return false;
        }
        for(int i = 2; i <= number / 2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    
}
