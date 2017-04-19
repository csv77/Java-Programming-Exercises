package scoresinafile;

import java.io.File;
import java.util.Scanner;

public class ScoresInAFile {

    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.out.println("Usage: java filename");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("The file " + args[0] + " does not exists");
            System.exit(2);
        }
        
        int sum = 0;
        int count = 0;
        
        try(Scanner input = new Scanner(file);){
            while(input.hasNext()){
                sum += input.nextInt();
                count++;
            }
        }
        
        System.out.println("The sum is: " + sum + "\naverage: " + (double)sum/count);
    }
}
