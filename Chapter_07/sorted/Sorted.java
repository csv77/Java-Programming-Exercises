package sorted;

import java.util.Scanner;

public class Sorted {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list: ");
        int length = input.nextInt();
        int[] numberOfArrays = new int[length];
        for(int i = 0;  i < length; i++){
            numberOfArrays[i] = input.nextInt();
        }
        if(isSorted(numberOfArrays)){
            System.out.println("The list is already sorted");
        }
        else{
            System.out.println("The list is not sorted");
        }
    }
    
    public static boolean isSorted(int[] list){
        boolean sorted = true;
        for(int i = 1; sorted != false && i < list.length; i++){
            if(list[i - 1] > list[i]){
                sorted = false;
            }
        }
        return sorted;
    }
    
    public static void displayArray(int[] array){
        for(int a : array){
            System.out.printf("[%4d] ", a);
        }
    }
}
