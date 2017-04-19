package countoccurrenceofnumbers;

import java.util.Arrays;
import java.util.Scanner;

public class CountOccurrenceOfNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 100: ");
        String data = input.nextLine();
        String[] data2 = data.split(" ");
        int[] numbers = new int[data2.length - 1];
        int[] counts = new int[100];
        for(int i = 0; i < data2.length - 1; i++){
            numbers[i] = Integer.parseInt(data2[i]);
            counts[numbers[i]-1]++;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length; i++){
            if(i == 0){
                if(counts[numbers[i] - 1] == 1){
                    System.out.println(numbers[i] + " occurs " + counts[numbers[i] - 1] + " time");
                }
                else{
                    System.out.println(numbers[i] + " occurs " + counts[numbers[i] - 1] + " times");
                }
            }
            else if(numbers[i] != numbers[i - 1]){
                if(counts[numbers[i] - 1] == 1){
                    System.out.println(numbers[i] + " occurs " + counts[numbers[i] - 1] + " time");
                }
                else{
                    System.out.println(numbers[i] + " occurs " + counts[numbers[i] - 1] + " times");
                }
            }
        }
    }
}
