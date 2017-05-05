package exercise_17_19;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_17_19 {

    public static void main(String[] args) {
        System.out.print("Enter the filename: ");
        String fileName = new Scanner(System.in).nextLine();
        
        try {
            try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("Chapter_17/" + fileName))) {
                int value;
                while((value = input.read()) != -1) {
                    System.out.print(Integer.toHexString(value).toUpperCase());
                }
            }
            System.out.println();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
