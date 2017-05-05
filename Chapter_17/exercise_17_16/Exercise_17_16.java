package exercise_17_16;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_17_16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input filename: ");
        int[] chars = new int[256];
        
        try {
            try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("Chapter_17/" + scanner.nextLine()))) {
                int character;
                while((character = input.read()) != -1) {
                    chars[character]++;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        System.out.printf("%10s%10s%10s\n", "Character", "ASCII code", "Count");
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != 0) {
                System.out.printf("%10c%10d%10d\n", i, i, chars[i]);
            }
        }
    }
    
}
