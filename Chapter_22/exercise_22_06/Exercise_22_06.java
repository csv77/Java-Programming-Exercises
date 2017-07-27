package exercise_22_06;

public class Exercise_22_06 {

    public static void main(String[] args) {
        long[] gcdMillis = new long[6];
        long[] gcdEuclidMillis = new long[6];
        
        for(int i = 40; i < 46; i++) {
            long n = fib(i);
            long m = fib(i + 1);
            
            long startTime = System.currentTimeMillis();
            gcd(n, m);
            long endTime = System.currentTimeMillis();
            gcdMillis[i - 40] = endTime - startTime;
            
            startTime = System.currentTimeMillis();
            gcdEuclid(n, m);
            endTime = System.currentTimeMillis();
            gcdEuclidMillis[i - 40] = endTime - startTime;
        }
        
        System.out.println("execution time(ms)|          40          41          42          43          44          45");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("GCD               |%12d%12d%12d%12d%12d%12d\n", gcdMillis[0], gcdMillis[1],
                gcdMillis[2], gcdMillis[3], gcdMillis[4], gcdMillis[5]);
        System.out.printf("GCDEuclid         |%12d%12d%12d%12d%12d%12d\n", gcdEuclidMillis[0], gcdEuclidMillis[1],
                gcdEuclidMillis[2], gcdEuclidMillis[3], gcdEuclidMillis[4], gcdEuclidMillis[5]);
        
    }
    
    public static long gcd(long m, long n) {
        long gcd = 1;
        
        if(m % n == 0) {
            return n;
        }
        
        for(long k = n / 2; k >= 1; k--) {
            if(m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }
        return gcd;
    }
    
    public static long gcdEuclid(long m, long n) {
        if(m % n == 0) {
            return n;
        }
        else {
            return gcd(n, m % n);
        }
    }
    
    public static long fib(long n) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;
        
        if(n == 0) {
            return f0;
        }
        else if(n == 1) {
            return f1;
        }
        else if(n == 2) {
            return f2;
        }
        
        for(int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }
}
