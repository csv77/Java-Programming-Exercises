package exercise_24_04;

import exercise_19_02.GenericStack;

public class Exercise_24_04 {
    private static final int COUNT = 50;
    
    public static void main(String[] args) {
        GenericStack<Integer> stack = new GenericStack<>();
        
        int number = 2;
        while(stack.size() < COUNT) {
            if(isPrime(number)) {
                stack.push(number);
            }
            number++;
        }
        
        int i = 1;
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
            if(i++ % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static boolean isPrime(int number) {
    boolean isPrime = true;

        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                isPrime = false;
                break;
            }
        }

    return isPrime;
  }

}
