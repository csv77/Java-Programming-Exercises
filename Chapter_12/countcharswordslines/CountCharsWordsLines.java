package countcharswordslines;

import java.io.File;
import java.util.Scanner;

public class CountCharsWordsLines {

    public static void main(String[] args) throws Exception{
        if(args.length != 1){
            System.out.println("Usage: java filename");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists()){
            System.out.println("The file " + args[0] + " does not exists");
            System.exit(2);
        }
        
        int countOfChars = 0;
        int countOfLines = 0;
        int countOfWords = 0;
        
        try(Scanner input = new Scanner(file);){
            while(input.hasNext()){
                String s1 = input.nextLine();
                countOfLines++;
                countOfChars += s1.length();
            }
        }
        
        try(Scanner input = new Scanner(file);){
            while(input.hasNext()){
                String s2 = input.next();
                countOfWords++;
            }
        }
        
        System.out.println("The file " + file.getName() + " has:\n" +
                           countOfLines + " lines,\n" + 
                           countOfWords + " words,\n" + 
                           countOfChars + " characters.");
        
    }
    
    
    
}
