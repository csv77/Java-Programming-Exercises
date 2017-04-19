package testmyinteger;

public class MyInteger {
    private int value;
    
    MyInteger(int value){
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }
    public boolean isEven(){
        return isEven(value);
    }
    public boolean isOdd(){
        return isOdd(value);
    }
    public boolean isPrime(){
        return isPrime(value);
    }
    public static boolean isEven(int value){
        return value % 2 == 0;
    }
    public static boolean isOdd(int value){
        return value % 2 != 0;
    }
    public static boolean isPrime(int value){
        if(value == 1){
            return false;
        }
        for(int i = 2; i <= value / 2; i++){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isEven(MyInteger myInt){
        return myInt.isEven();
    }
    public static boolean isOdd(MyInteger myInt){
        return myInt.isOdd();
    }
    public static boolean isPrime(MyInteger myInt){
        return myInt.isPrime();
    }
    public boolean equals(int value){
        return this.value == value;
    }
    public boolean equals(MyInteger myInt){
        return myInt.value == this.value;
    }
    public static int parseInt(char[] chars){
        int value = 0;
        for(int i = 0; i < chars.length; i++){
            value += chars[i] - 48;
            if(i != chars.length - 1){    
                value *= 10;
            }
        }
        return value;
    }
    public static int parseInt(String string){
        char[] chars = string.toCharArray();
        return parseInt(chars);
    }
    
}
