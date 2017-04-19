package testrational2;

import java.math.*;

public class Rational extends Number implements Comparable {
    private BigInteger[] r = new BigInteger[2];
    
    public Rational() {
        this(new BigInteger("0"), new BigInteger("1"));
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
        r[0] = (denominator.compareTo(BigInteger.ZERO) > 0
                ? BigInteger.ONE : new BigInteger("-1")).multiply(numerator.divide(gcd));
        r[1] = denominator.divide(gcd);
    }

    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n;
        BigInteger n2 = d;
        BigInteger gcd = BigInteger.ONE;

        for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
            if (n1.remainder(k).compareTo(BigInteger.ZERO) == 0 && n2.remainder(k).compareTo(BigInteger.ZERO) == 0) 
                gcd = k;
        }
        return gcd;
    }
    
    public BigInteger getNumerator() {
        return r[0];
    }

    public BigInteger getDenominator() {
        return r[1];
    }

    public Rational add(Rational secondRational) {
        BigInteger n = (r[0].multiply(secondRational.getDenominator())).add(
                r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational subtract(Rational secondRational) {
        BigInteger n = (r[0].multiply(secondRational.getDenominator())).subtract(
                r[1].multiply(secondRational.getNumerator()));
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational multiply(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getNumerator());
        BigInteger d = r[1].multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        BigInteger n = r[0].multiply(secondRational.getDenominator());
        BigInteger d = r[1].multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    @Override  
    public String toString() {
        if (r[1].compareTo(BigInteger.ONE) == 0)
            return r[0] + "";
        else
            return r[0] + "/" + r[1];
    }

    @Override
    public boolean equals(Object other) {
        if ((this.subtract((Rational)(other))).getNumerator().compareTo(BigInteger.ZERO) == 0)
            return true;
        else
            return false;
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override 
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override
    public double doubleValue() {
        return this.getNumerator().doubleValue() / this.getDenominator().doubleValue();
    }

    @Override 
    public long longValue() {
        return (long)doubleValue();
    }

    @Override 
    public int compareTo(Object o) {
        BigInteger zero = BigInteger.ZERO;
        BigInteger n = this.subtract((Rational)o).getNumerator();
        if (n.compareTo(zero) > 0)
            return 1;
        else if (n.compareTo(zero) < 0)
            return -1;
        else
            return 0;
    }
}