package mergetwosortedlists;

import java.util.Scanner;
import java.util.Arrays;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        int[] list1 = enterList(1);
        int[] list2 = enterList(2);
        int[] list3 = merge(list1, list2);
        System.out.print("The merged list is ");
        displayList(list3);
    }
    
    public static void displayList(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
    
    public static int[] enterList(int number){
        Scanner input = new Scanner(System.in);
        int length = 0;
        System.out.print("Enter list" + number + ": ");
        length = input.nextInt();
        int[] list = new int[length];
        for(int i = 0; i < list.length; i++){
            list[i] = input.nextInt();
        }
        return list;
    }
    
    public static int[] merge(int[] list1, int[] list2){
        int[] mergedList = new int[list1.length + list2.length];
        for(int i = 0; i < list1.length; i++){
            mergedList[i] = list1[i];
        }
        for(int i = 0; i < list2.length; i++){
            mergedList = insertValueInArray(mergedList, list2[i]);
        }
        return mergedList;
    }
    
    public static int[] insertValueInArray(int newList[], int number){
        int index = Arrays.binarySearch(newList, number);
        if(index < 0){
            index = index * (-1) - 1;
        }
        for(int i = newList.length - 2; i >= 0; i--){
            if(i >= index){
                newList[i + 1] = newList[i];
            }
        }
        newList[index] = number;
        return newList;
    }
}
