package countsequence;

import java.math.BigInteger;
import testrational2.Rational;

public class CountSequence {

    public static void main(String[] args) {
        Rational sum = new Rational(BigInteger.ZERO, BigInteger.ONE);
        for(BigInteger i = BigInteger.ONE; i.compareTo(new BigInteger("19")) <= 0; i = i.add(BigInteger.ONE)) {
            sum = sum.add(new Rational(i, i.add(BigInteger.ONE)));
        }
        System.out.println(sum);
    }
}
