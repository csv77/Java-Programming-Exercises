package exercise_18_31;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_18_31 {

    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Usage: java Exercise_18_30 dirName oldWord newWord");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.isDirectory() && !file.isFile()) {
            System.out.println("The " + file.getName() + " is not a file or directory");
            System.exit(2);
        }
        renameOccurences(file, args[1], args[2]);
        System.out.println("All the word " + args[1] + " were renamed to " + args[2]);
    }
    
    public static void renameOccurences(File file, String oldWord, String newWord) {
        if(file.isFile()) {
            ArrayList<String> list = new ArrayList<>();
            try {
                try(Scanner input = new Scanner(file);) {
                    while(input.hasNext()) {
                        String text = input.nextLine();
                        String newText = text.replace(oldWord, newWord);
                        list.add(newText);
                    }
                }
                try(PrintWriter output = new PrintWriter(file);) {
                    for(int i = 0; i < list.size(); i++) {
                        output.println(list.get(i));
                    }
                }
            }
            catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        }
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for(int i = 0; i < files.length; i++) {
                    renameOccurences(files[i], oldWord, newWord);
                }
            }
        }
    }
}