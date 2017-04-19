package testrational2;

import java.math.*;

public class TestRational2 {

    public static void main(String[] args) {
        Rational a1 = new Rational(new BigInteger("400"), new BigInteger("200"));
        Rational b1 = new Rational(new BigInteger("200"), new BigInteger("300"));
        System.out.println(a1.add(b1));
        System.out.println(b1.subtract(a1));
        System.out.println(a1.multiply(b1));
        System.out.println(b1.divide(a1));
        
    }
    
}
