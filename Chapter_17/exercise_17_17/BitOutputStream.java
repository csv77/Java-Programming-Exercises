package exercise_17_17;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitOutputStream implements AutoCloseable {
    private FileOutputStream out;
    int b;
    int bitPos;
    
    public BitOutputStream(File file) throws IOException {
        out = new FileOutputStream(file);
        b = 0;
        bitPos = 0;
    }
    
    public void writeBit(char bit) throws IOException {
        b = b << 1;
        if(bit == '1') {
            b = b | 1;
        }

        bitPos++;
        if(bitPos == 8) {
            out.write(b);
            bitPos = 0;
        }
    }
    
    public void writeBit(String bit) throws IOException {
        for(int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }
    
    @Override
    public void close() throws IOException {
        if(bitPos > 0) {
            b = b << 8 - bitPos;
            out.write(b);
        }
        out.close();
    }
}
