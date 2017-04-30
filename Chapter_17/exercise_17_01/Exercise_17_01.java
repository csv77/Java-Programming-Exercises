package exercise_17_01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Exercise_17_01 {

    public static void main(String[] args) {
        try {
            try(PrintWriter output = new PrintWriter(new FileOutputStream("Chapter_17/Exercise17_01.txt", true))) {
                for(int i = 0; i < 100; i++) {
                    output.write((int)(Math.random() * 100) + " ");
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    
}
