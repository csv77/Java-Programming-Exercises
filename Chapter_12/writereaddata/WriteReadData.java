package writereaddata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WriteReadData {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Exercise12_15.txt");
        
        if(file.exists()){
            System.out.println("The file " + file.getName() + " is already exists!");
            System.exit(1);
        }
        
        try(PrintWriter output = new PrintWriter(file);){
            int[] array = new int[100];
            for(int i = 0; i < array.length; i++){
                array[i] = (int)(Math.random() * 500 + 1);
                output.print(array[i]);
                output.print(" ");
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        try(Scanner input = new Scanner(file);){
            while(input.hasNext()){
                list.add(input.nextInt());
            }
        }
        
        Collections.sort(list);
        
        System.out.println(list.toString());
        
    }
    
}
