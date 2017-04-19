package occurrencesofletters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OccurrencesOfLetters {

    public static void main(String[] args) {
        File file = getFile();
        
        if(!file.exists()) {
            System.out.println("File " + file.getName() + " does not exists");
            System.exit(1);
        }
        int[] count = new int[26];
        try{
            try(Scanner input = new Scanner(file);) {
                while(input.hasNext()) {
                    String line = input.nextLine().toUpperCase();
                    countLetters(count, line);
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        for(int i = 0; i < count.length; i++) {
            System.out.println("Number of " + (char)('A' + i) + "'s: " + count[i]);
        }
        
        
    }
    
    public static void countLetters(int[] count, String line) {
        for(int i = 0; i < line.length(); i++) {
            if(Character.isLetter(line.charAt(i))) {
                count[line.charAt(i) - 'A']++;
            }
        }
    }
    
    public static File getFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        File file = new File(input.next());
        return file;
    }
    
    
}
