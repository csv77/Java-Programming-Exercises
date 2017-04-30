package exercise_17_02;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise_17_02 {

    public static void main(String[] args) {
        try {
            try(DataOutputStream output = new DataOutputStream(new FileOutputStream("Chapter_17/Exercise17_02.dat", true))) {
                for(int i = 0; i < 100; i++) {
                    output.write((int)(Math.random() * (Integer.MAX_VALUE + 1)));
                }
            }
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }
    
}
