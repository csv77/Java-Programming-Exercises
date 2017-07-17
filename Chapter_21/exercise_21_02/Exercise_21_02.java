package exercise_21_02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Exercise_21_02 {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java Exercise_21_02 filename");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists() || !file.isFile()) {
            System.out.println("The file " + file.getName() + " doesn't exists, or it is a directory");
            System.exit(2);
        }
        
        try(BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));) {
            String line = "";
            StringBuilder text = new StringBuilder("");
            while((line = input.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
            String[] words = text.toString().split("[ \n\t\r.,;:!?(){}]");
            TreeSet<String> set = new TreeSet<>(Arrays.asList(words));
            for(String element : set) {
                System.out.println(element);
            }
            
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
    }
}
