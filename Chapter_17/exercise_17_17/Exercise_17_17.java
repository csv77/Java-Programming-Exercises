package exercise_17_17;

import java.io.File;
import java.io.IOException;

public class Exercise_17_17 {

    public static void main(String[] args) {
        try {
            try(BitOutputStream out = new BitOutputStream(new File("Chapter_17/Exercise17_17.dat"))) {
                out.writeBit("0110000101100001011000010100000101000001010000010110101101001011");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
