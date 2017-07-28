package exercise_22_08;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Exercise_22_08 {

    public static void main(String[] args) {
        long n = 100000L;
        
        try(RandomAccessFile inout = new RandomAccessFile("PrimeNumbers.dat", "rw");) {
            ArrayList<Long> list = new ArrayList<>();

            long count = 0;
            long number = 2;
            int squareRoot = 1;

            if(inout.length() > 0) {
                inout.seek(inout.length() - 8);
                number = inout.readLong() + 1;
                inout.seek(0);
                try {
                    for(int i = 0; i < 1000; i++) {
                        list.add(inout.readLong());
                    }
                }
                catch (EOFException e) {
                }
                squareRoot = (int)(Math.sqrt(number)) + 1;
                count = inout.length() / 8;
            }
            
            while(number <= n) {
                boolean isPrime = true;
                if(squareRoot * squareRoot < number) {
                    squareRoot++;
                }
                
                while(isPrime) {
                    for(int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                        if(number % list.get(k) == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    
                    if(inout.getFilePointer() == inout.length()) {
                        break;
                    }
                    
                    if(isPrime) {
                        list.clear();
                        try {
                            for(int i = 0; i < 1000; i++) {
                                list.add(inout.readLong());
                            }
                        }
                        catch (EOFException e) {
                        }
                    }
                }
                if(isPrime) {
                    count++;
                    System.out.println(count + ". prime: " + number + "\t" + list.size());
                    inout.writeLong(number);
                    list.clear();
                    inout.seek(0);
                    try {
                        for(int i = 0; i < 1000; i++) {
                            list.add(inout.readLong());
                        }
                    }
                    catch (EOFException e) {
                    }
                }
                number++;
            }
            
            System.out.println(count + " prime(s) are less than or equal to " + n);            
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("IO Exception");
        }
    }
}
