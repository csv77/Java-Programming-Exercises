package exercise_20_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_20_01 {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java Exercise_20_01 filename");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists()) {
            System.out.println("The file " + args[0] + " is not exists");
            System.exit(2);
        }
        
        ArrayList<String> list = new ArrayList<>();
        
        try(Scanner input = new Scanner(file);) {
            while(input.hasNext()) {
                String[] words = input.nextLine().split(" ");
                for(String word : words) {
                    if(Character.isLetter(word.charAt(0))) {
                        list.add(word);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        
        Collections.sort(list);
        System.out.println(list);
    }
}
