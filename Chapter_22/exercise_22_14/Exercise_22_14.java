package exercise_22_14;

import java.util.ArrayList;
import java.util.List;

public class Exercise_22_14 {

    public static void main(String[] args) {
        long[] listing_22_5 = new long[6];
        long[] listing_22_6 = new long[6];
        long[] listing_22_7 = new long[6];
        int j = 0;
        for(int i = 8000000; i < 20000000; i += 2000000, j++) {
            listing_22_5[j] = primeNumbers_22_5(i);
            listing_22_6[j] = primeNumbers_22_6(i);
            listing_22_7[j] = primeNumbers_22_7(i);
        }
        
        System.out.println("execution times(ms)|     8000000    10000000    12000000    14000000    16000000    18000000");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("Listing 22.5       |%12d%12d%12d%12d%12d%12d\n", listing_22_5[0], listing_22_5[1],
                listing_22_5[2], listing_22_5[3], listing_22_5[4], listing_22_5[5]);
        System.out.printf("Listing 22.6       |%12d%12d%12d%12d%12d%12d\n", listing_22_6[0], listing_22_6[1],
                listing_22_6[2], listing_22_6[3], listing_22_6[4], listing_22_6[5]);
        System.out.printf("Listing 22.7       |%12d%12d%12d%12d%12d%12d\n", listing_22_7[0], listing_22_7[1],
                listing_22_7[2], listing_22_7[3], listing_22_7[4], listing_22_7[5]);
    }
    
    public static long primeNumbers_22_5(int n) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        int number = 2;
        while(number <= n) {
            boolean isPrime = true;
            for(int divisor = 2; divisor <= (int)(Math.sqrt(number)); divisor++) {
                if(number % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
            }
            number++;
        }
        return System.currentTimeMillis() - startTime;
    }
    
    public static long primeNumbers_22_6(int n) {
        long startTime = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int number = 2;
        int squareRoot = 1;
        while(number <= n) {
            boolean isPrime = true;
            if(squareRoot * squareRoot < number) {
                squareRoot++;
            }
            for(int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if(number % list.get(k) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
                list.add(number);
            }
            number++;
        }
        return System.currentTimeMillis() - startTime;
    }
    
    public static long primeNumbers_22_7(int n) {
        long startTime = System.currentTimeMillis();
        boolean[] primes = new boolean[n + 1];
        for(int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        for(int k = 2; k <= n / k; k++) {
            if(primes[k]) {
                for(int i = k; i <= n / k; i++) {
                    primes[k * i] = false;
                }
            }
        }
        int count = 0;
        for(int i = 2; i < primes.length; i++) {
            if(primes[i]) {
                count++;
            }
        }
        return System.currentTimeMillis() - startTime;
    }
}
