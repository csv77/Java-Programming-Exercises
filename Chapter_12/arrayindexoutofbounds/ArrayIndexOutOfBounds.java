package arrayindexoutofbounds;

import java.util.Scanner;

public class ArrayIndexOutOfBounds {

    public static void main(String[] args) {
        int[] array = new int[100];
        fillArray(array);
        try{
            int index = new Scanner(System.in).nextInt();
            System.out.println("The " + index + ". element of the array is: " + array[index]);
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Out of Bounds.");
        }
        
    }
    
    public static void fillArray(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * 100);
        }
    }
    
}
