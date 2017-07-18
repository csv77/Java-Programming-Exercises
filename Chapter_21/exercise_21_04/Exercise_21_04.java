package exercise_21_04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise_21_04 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();

        File file = new File(filename);
        try {
            countOfLetters(file);
        } 
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch(IOException ex) {
            System.out.println("IOException");
        }
    }
    
    public static void countOfLetters(File file) throws FileNotFoundException, IOException {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        String line = "";
        int countOfVowels = 0;
        int countOfConsonants = 0;
        try(BufferedReader input = new BufferedReader(new FileReader(file));) {
            while((line = input.readLine()) != null) {
                for(char ch : line.toUpperCase().toCharArray()) {
                    if(vowels.contains(ch)) {
                        countOfVowels++;
                    }
                    else if(Character.isLetter(ch)) {
                        countOfConsonants++;
                    }
                }
            }
        }
        System.out.println("The numer of vowels in file " + file.getName() + ": " + countOfVowels);
        System.out.println("The numer of consonants in file " + file.getName() + ": " + countOfConsonants);
    }
}
