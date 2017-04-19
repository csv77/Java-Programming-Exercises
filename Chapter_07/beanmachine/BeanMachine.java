package beanmachine;

import java.util.Scanner;

public class BeanMachine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfBalls = 0;
        int numberOfSlots = 0;
        System.out.print("Enter the number of balls to drop: ");
        numberOfBalls = input.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        numberOfSlots = input.nextInt();
        String[] path = new String[numberOfBalls];
        int[] slots = new int[numberOfSlots];
        for(int i = 0; i < numberOfBalls; i++){
            path[i] = generatePath(numberOfSlots);
            displayPath(path[i]);
            calculateSlot(slots, path[i]);
        }
        displaySlots(slots);
    }
    
    public static String generatePath(int numberOfSlots){
        String path = "";
        for(int i = 0; i < numberOfSlots - 1; i++){
            int number = (int)(Math.random() * 2);
            if(number == 1){
                path += "R";
            }
            else if(number == 0){
                path +="L";
            }
        }
        return path;
    }
    
    public static void displayPath(String path){
        System.out.print(path + "\n");
    }
    
    public static void displaySlots(int[] slots){
        int maxSlot = maxElement(slots);
        for(int i = maxSlot; i > 0; i--){
            for(int j = 0; j < slots.length; j++){
                if(slots[j] < i){
                    System.out.print(" ");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    
    public static int maxElement(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
    
    public static void calculateSlot(int[] slot, String path){
        int right = 0;
        char[] chars = path.toCharArray();
        for(int k = 0; k < chars.length; k++){    
            if(chars[k] == 'R'){
                right++;
            }
        }
        slot[right]++;
    }
}
