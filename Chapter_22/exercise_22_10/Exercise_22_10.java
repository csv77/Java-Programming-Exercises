package exercise_22_10;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise_22_10 {

    public static void main(String[] args) {
        try(DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("PrimeNumbers.dat")));) {
            for(long i = 10; i < 10000000000L; i *= 10) {
                long number;
                try {
                    for(long j = 1; (number = input.readLong()) < i ; j++) {
                        if(j == 1) {
                            System.out.println("Prime numbers less than or equal to " + i + ": ");
                        }
                        System.out.println(number);
                    }
                }
                catch (EOFException e) {
                    System.out.println("All data from file PrimeNumbers.dat were read");
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
    }
}
