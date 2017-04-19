package datasorted;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSorted {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("SortedStrings.txt");
        if(!file.exists()){
            System.out.println("The file " + file.getName() + " does not exists!");
            System.exit(1);
        }
        
        String s1 = "";
        String s2 = "";
        
        boolean isSorted = true;
        
        try(Scanner input = new Scanner(file);){
            s1 = input.next();
            while(input.hasNext() && isSorted){
                s2 = input.next();
                if(s1.compareTo(s2) > 0){
                    isSorted = false;
                    System.out.println("The strings in file " + file.getName() + " are not sorted.");
                    System.out.println("These two are not sorted: " + s1 + ", " + s2);
                }
                s1 = s2;
            }
        }
        if(isSorted){
            System.out.println("The string in file " + file.getName() + " are sorted.");
        }
    }
    
}
