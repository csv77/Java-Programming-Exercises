package exercise_17_04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_17_04 {

    public static void main(String[] args) {
        String dir = "Chapter_17/";
        if(args.length!= 2) {
            System.out.println("Usage java Exercise_17_04 sourcefile targetfile");
            System.exit(1);
        }
        
        File sourceFile = new File(dir + args[0]);
        File targetFile = new File(dir + args[1]);
        
        if(!sourceFile.exists()) {
            System.out.println("The file " + dir + sourceFile.getName() + " does not exists");
            System.exit(2);
        }
        
        try {
            try(Scanner input = new Scanner(new FileInputStream(sourceFile));
                DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(targetFile)));) {
                String line = "";
                int inputFileSize = 0;
                while(input.hasNext()) {
                    line = input.nextLine() + "\n";
                    output.writeUTF(line);
                    inputFileSize += line.length();
                }
                System.out.println("The size of " + sourceFile.getName() + ": " + inputFileSize + " bytes");
                System.out.println("The size of " + targetFile.getName() + ": " + output.size() + " bytes");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
    
}
