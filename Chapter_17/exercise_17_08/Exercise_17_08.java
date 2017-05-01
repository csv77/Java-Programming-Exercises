package exercise_17_08;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise_17_08 {

    public static void main(String[] args) {
        int count;
        try {
            try(RandomAccessFile raf = new RandomAccessFile("Chapter_17/Exercise17_08.dat", "rw")) {
                if(raf.length() != 0) {
                    count = raf.readInt() + 1;
                }
                else {
                    count = 1;
                }
                raf.seek(0);
                raf.writeInt(count);
            }
            System.out.println("Count of execution: " + count);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
