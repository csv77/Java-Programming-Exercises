package exercise_17_12;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise_17_12 {

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Usage: java Exercise_17_12 SourceFile1 ... SourceFilen TargetFile");
            System.exit(1);
        }
        
        RandomAccessFile[] files = new RandomAccessFile[args.length - 1];
        
        try {
            try(RandomAccessFile target = new RandomAccessFile("Chapter_17/" + args[args.length - 1], "rw")) {
                for(int i = 0; i < files.length; i++) {
                        files[i] = new RandomAccessFile("Chapter_17/" + args[i], "r");
                        byte[] bytes = new byte[(int)files[i].length()];
                        files[i].seek(0);
                        files[i].read(bytes);
                        target.seek(target.length());
                        target.write(bytes);
                        files[i].close();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
