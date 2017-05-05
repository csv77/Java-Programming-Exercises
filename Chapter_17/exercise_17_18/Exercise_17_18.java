package exercise_17_18;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_17_18 {

    public static void main(String[] args) {
        System.out.print("Enter the filename: ");
        String fileName = new Scanner(System.in).nextLine();
        String binary = "";
        
        try {
            try(BufferedInputStream input = new BufferedInputStream(new FileInputStream("Chapter_17/" + fileName))) {
                int value;
                while((value = input.read()) != -1) {
                    binary += getBits(value) + " ";
                }
            }
            System.out.println(binary);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getBits(int value) {
        value = (value << 24) >> 24;
        String binary = Integer.toBinaryString(value);
        for(int i = 0; i < 8 - binary.length(); i++) {
            binary = "0" + binary;
        }
        return binary;
    }
}
