package twinprimes;

public class TwinPrimes {

    public static void main(String[] args) {
        printTwinPrimes();
    }
    
    public static boolean isPrime(int number){
        for(int i = 2; i <= number / 2; i++){
            if(number % i ==0){
                return false;
            }
        }
        return true;
    }
    
    public static void printTwinPrimes(){
        for(int i = 2; i < 1000; i++){
            if(isPrime(i) && isPrime(i+2)){
                System.out.printf("(%d, %d)\n", i, i+2);
            }
        }
    }
}
