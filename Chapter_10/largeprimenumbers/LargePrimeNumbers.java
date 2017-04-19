package largeprimenumbers;

import java.math.BigInteger;

public class LargePrimeNumbers {

    public static void main(String[] args) {
        BigInteger number = new BigInteger(Long.MAX_VALUE + "");
        int count = 0;
        while(count < 5){
            number = number.add(new BigInteger("1"));
            if(isPrime(number)){
                System.out.println(number);
                count++;
            }
        }
    }
    
    public static boolean isPrime(BigInteger n){
        for(BigInteger i = new BigInteger("2"); i.compareTo(n.divide(new BigInteger("2"))) == -1;
                i = i.add(new BigInteger("1"))){
            if(BigInteger.ZERO.compareTo(n.remainder(i)) == 0){
                return false;
            }
        }
        return true;
    }
}
