package exercise_17_03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise_17_03 {

    public static void main(String[] args) throws IOException {
        int sum = 0;
        File file = new File("Chapter_17/Exercise17_03.dat");
        
        if(!file.exists()) {
            //create Exercise17_03.dat file containing unspecified number of integers
            try(DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
                for(int i = 0; i < (int)(Math.random() * 100); i++) {
                    output.writeInt((int)(Math.random() * 100));
                }
            }
        }
        
        //read integers from Exercise_17_03.dat to get the sum of the numbers in the file
        try(DataInputStream input = new DataInputStream(new FileInputStream("Chapter_17/Exercise17_03.dat"))) {
            int count = input.available() / 4;
            while(count > 0) {
                sum += input.readInt();
                count--;
            }
        }
        
        System.out.println("The sum of the number is file Exercise17_03.dat: " + sum);
    }
    
}
