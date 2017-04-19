package bubblesort;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] arrayOfNumbers = new double[10];
        for(int i = 0; i < 10; i++){
            arrayOfNumbers[i] = input.nextDouble();
        }
        sortArray(arrayOfNumbers);
        displayArray(arrayOfNumbers);
    }
    
    public static void sortArray(double[] numbers){
        for(int i = numbers.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(numbers[j]>numbers[j+1]){
                    double temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
    
    public static void displayArray(double[] numbers){
        for(double a : numbers){
            System.out.printf("[%4.1f] ", a);
        }
    }
    
}
