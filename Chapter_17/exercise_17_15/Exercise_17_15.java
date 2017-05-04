package exercise_17_15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_17_15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input filename: ");
        String inputFile = scanner.next();
        System.out.print("Name of decrypted file: ");
        String outputFile = scanner.next();
        
        try {
            try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("Chapter_17/" + inputFile));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Chapter_17/" + outputFile))) {
                int value;
                while((value = input.read()) != -1) {
                    output.write(value - 5);
                }
            }
        }//4
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
