package consecutivefour;

import java.util.Scanner;

public class ConsecutiveFour {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfValues = 0;
        System.out.print("Enter the number of values: ");
        numberOfValues = input.nextInt();
        int[] listOfNumbers = new int[numberOfValues];
        System.out.print("Enter the values: ");
        for(int i = 0; i < listOfNumbers.length; i++){
            listOfNumbers[i] = input.nextInt();
        }
        if(isConsecutiveFour(listOfNumbers)){
            System.out.println("The list has consecutive fours");
        }
        else{
            System.out.println("The list has no consecutive fours");
        }
    }
    
    public static boolean isConsecutiveFour(int [] values){
        boolean isFour = false;
        for(int i = 0; isFour != true && i < values.length - 3; i++){
            isFour = true;
            for(int j = i + 1; isFour != false && j < i + 4; j++){
                if(values[j] != values[j - 1]){
                    isFour = false;
                }
            }
        }
        return isFour;
    }
    
}
