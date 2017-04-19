package printdistinctnumbers;

import java.util.Scanner;

public class PrintDistinctNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        System.out.print("Enter 10 numbers: ");
        numbers[0] = input.nextInt();
        int k = 1;
        for(int i = 1; i < 10; i++){
            int readNumber = input.nextInt();
            boolean contain = false;
            for(int j = 0; j < i; j++){
                if(numbers[j] == readNumber){
                    contain = true;
                }
            }
            if(!contain){
                numbers[k++] = readNumber;
            }
        }
        System.out.println("The number of distinct number is " + k);
        System.out.print("The distinct numbers are: ");
        for(int i = 0; i < k; i++){
            System.out.print(numbers[i] + " ");
        }
    }
    
}
