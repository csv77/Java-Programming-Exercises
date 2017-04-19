package computedeviation;
import java.lang.Math;
import java.util.Scanner;

public class ComputeDeviation {

   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] numbers = new double[10];
        for(int i = 0; i < 10; i++){
            numbers[i] = input.nextDouble();
        }
        System.out.printf("The mean is %4.2f\n", mean(numbers));
        System.out.printf("The standard deviation is %7.5f\n", deviation(numbers));
   }
   
   public static double deviation(double[] x){
       double sum = 0;
       for(double a : x){
           sum += Math.pow(a - mean(x), 2);
       }
       return Math.sqrt(sum / (x.length - 1));
   }
   
   public static double mean(double[] x){
       double sum = 0;
       for(double a : x){
           sum += a;
       }
       return sum / x.length;
   }
}
