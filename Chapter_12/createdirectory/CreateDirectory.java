package createdirectory;

import java.io.File;
import java.util.Scanner;

public class CreateDirectory {

    public static void main(String[] args) {
        System.out.println("Enter the directory's name: ");
        File dir = new File(new Scanner(System.in).next());
        
        if(dir.exists()) {
            System.out.println("Directory is already exists");
            System.exit(1);
        }
        
        if(dir.mkdirs()) {
            System.out.println("Directory created successfully");
        }
        
        
    }
    
}
