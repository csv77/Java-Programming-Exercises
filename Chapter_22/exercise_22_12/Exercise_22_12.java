package exercise_22_12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise_22_12 {

    public static void main(String[] args) {
        int countOfPrimes = 100;
        try(RandomAccessFile raf = new RandomAccessFile("PrimeNumbers.dat", "r");){
            raf.seek(raf.length() - 8 * countOfPrimes);
            for(int i = 0; i < countOfPrimes; i++) {
                System.out.println(raf.readLong());
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
}
