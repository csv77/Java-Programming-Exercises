package smallestelement;
import java.util.Arrays;
import java.util.Scanner;

public class SmallestElement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers to find the smallest: ");
        double[] numbers = new double[10];
        for(int i = 0; i < 10; i++){
            numbers[i] = input.nextDouble();
        }
        System.out.println("The smallest is: " + min(numbers));
    }
    
    public static double min(double[] array){
        double min = array[0];
        for(double e: array){
            if(min > e){
                min = e;
            }
        }
        return min;
    }
    
}
