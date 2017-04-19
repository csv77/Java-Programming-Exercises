package divisible;

import java.math.BigInteger;


public class Divisible {

    public static void main(String[] args) {
        BigInteger nr = new BigInteger("10000000000000000000000000000000000000000000000000");
        BigInteger zero = BigInteger.ZERO;
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");
        int i = 0;
        while(i < 10){
            if(zero.equals(nr.remainder(two)) || zero.equals(nr.remainder(three))){
                System.out.println(nr);
                i++;
            }
            nr = nr.add(new BigInteger("1"));
        }
    }
    
}
