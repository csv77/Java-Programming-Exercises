package exercise_17_10;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise_17_10 {

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: java Exercise_17_10 sourceFile numberOfPieces");
            System.exit(1);
        }
        
        int numberOfPieces = Integer.parseInt(args[1]);
        File file = new File("Chapter_17/" + args[0]);
        
        try {
            try(RandomAccessFile raf = new RandomAccessFile(file, "r")) {
                int lengthOfPiece = (int)(raf.length() / numberOfPieces);
                
                for(int i = 0; i < numberOfPieces; i++) {
                    raf.seek(i * lengthOfPiece);
                    if(i < numberOfPieces - 1) {
                        byte[] bytes = new byte[lengthOfPiece];
                        raf.read(bytes);
                        writeBytesInNewFile(bytes, i + 1);
                    }
                    else {
                        int lastPiece = (int)(raf.length() - (numberOfPieces - 1) * lengthOfPiece);
                        byte[] bytes = new byte[lastPiece];
                        raf.read(bytes);
                        writeBytesInNewFile(bytes, i + 1);
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeBytesInNewFile(byte[] bytes, int number) {
        try {
            try(BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("Chapter_17/SourceFile." + number))) {
                output.write(bytes);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
