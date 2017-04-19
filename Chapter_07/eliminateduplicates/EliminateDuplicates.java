package eliminateduplicates;
import java.util.Arrays;
import java.util.Scanner;

public class EliminateDuplicates {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        int[] list = new int[10];
        for(int i = 0; i < 10; i++){
            list[i] = input.nextInt();
        }
        list = eliminateDuplicates(list);
        System.out.print("\nThe distinct numbers are: ");
        for(int i = 0; list[i] != 0 && i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
    
    public static int[] eliminateDuplicates(int[] list){
        int[] listWithoutDuplicates = new int[list.length];
        listWithoutDuplicates[0] = list[0];
        int k = 1;
        for(int i = 1; i < list.length; i++){
            boolean contain = false;
            for(int j = 0; j < i; j++){
                if(list[i] == list[j]){
                    contain = true;
                }
            }
            if(!contain){
                listWithoutDuplicates[k++] = list[i];
            }
        }
        return listWithoutDuplicates;
    }
}
