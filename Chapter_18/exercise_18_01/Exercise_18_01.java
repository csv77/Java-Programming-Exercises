package exercise_18_01;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise_18_01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        String n = scanner.nextLine();
        BigInteger bigN = new BigInteger(n);
        
        System.out.println("The factorial of " + bigN.toString() + " is: " + factorial(bigN));
    }
    
    public static BigInteger factorial(BigInteger n) {
        return factorial(n, BigInteger.ONE);
    }
    
    public static BigInteger factorial(BigInteger n, BigInteger result) {
        if(n.equals(BigInteger.ZERO)) {
            return result;
        }
        else {
            return factorial(n.subtract(BigInteger.ONE), result.multiply(n));
        }
        
    }
    
}
