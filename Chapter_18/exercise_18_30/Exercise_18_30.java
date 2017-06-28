package exercise_18_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise_18_30 {

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Exercise_18_30 dirName word");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.isDirectory() && !file.isFile()) {
            System.out.println("The " + file.getName() + " is not a file or directory");
            System.exit(2);
        }
        System.out.println("The word " + args[1] + " was found " + getOccurences(file, args[1]) + " times");
    }
    
    public static long getOccurences(File file, String word) {
        long numberOfWords = 0;
        if(file.isFile()) {
            try(Scanner input = new Scanner(file);) {
                while(input.hasNext()) {
                    if(input.next().contains(word)) {
                        numberOfWords++;
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
            return numberOfWords;
        }
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for(int i = 0; i < files.length; i++) {
                    numberOfWords += getOccurences(files[i], word);
                }
            }
        }
        return numberOfWords;
    }
}
