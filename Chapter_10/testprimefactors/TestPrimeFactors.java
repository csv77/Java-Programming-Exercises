package testprimefactors;
import java.util.Scanner;

public class TestPrimeFactors {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = input.nextInt();
        StackOfIntegers stack = new StackOfIntegers();
        smallestFactors(number, stack);
        System.out.println("The smallest factors are: ");
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    
    public static void smallestFactors(int number, StackOfIntegers stack){
        int i = 2;
        while(number > 1){
            if(number % i == 0){
                stack.push(i);
                number /= i;
            }
            else{
                i++;
            }
        }
    }
}
