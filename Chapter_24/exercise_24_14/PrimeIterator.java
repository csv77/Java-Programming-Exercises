package exercise_24_14;

import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer>{
    private int current = 1;
    private int limit;

    public PrimeIterator(int limit) {
        this.limit = limit;
    }
    
    private static boolean isPrime(int number) {
        for(int divisor = 2; divisor < number / 2; divisor++) {
            if(number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean hasNext() {
        current++;
        boolean notPrime = true;
        while(notPrime) {
            if(isPrime(current)) {
                notPrime = false;
            }
            else {
                current++;
            }
        }
        if(current >= limit) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Integer next() {
        return current;
    }
    
}
