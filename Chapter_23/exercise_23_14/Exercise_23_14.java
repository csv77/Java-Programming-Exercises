package exercise_23_14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Exercise_23_14 {
    public static final int MAX_ARRAY_SIZE = 100000;
    public static final int BUFFER_SIZE = 100000;
    
    public static void main(String[] args) {
        try {
            createFiles();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("IOException");
        }
        
        System.out.println("File size  |   5,000,000  10,000,000  15,000,000  20,000,000  25,000,000  30,000,000");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.print("Time       |");
        
        String name1 = "largedata";
        String name2 = "sortedfile";
        String ext = ".dat";
        
        for(int i = 5; i <= 30; i += 5) {
            System.out.printf("%12d", executionTimeExternalSort(name1 + i + ext, name2 + i + ext));
        }
        System.out.println();
    }
    
    public static void createFiles() throws FileNotFoundException, IOException {
        for(int i = 5; i <= 30; i += 5) {
            DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largedata" + i + ".dat")));

            for (int j = 0; j < i * 1000000; j++)
                output.writeInt((int)(Math.random() * 30000000));

            output.close();
        }
    }
    
    public static long executionTimeExternalSort(String sourcefile, String targetfile) {
        long startTime = System.currentTimeMillis();
        try {
            sort(sourcefile, targetfile);
        } catch (Exception ex) {
            System.out.println("IOException");
        }
        return System.currentTimeMillis() - startTime;
    }
    
    public static void sort(String sourcefile, String targetfile) throws Exception {
        int numberOfSegments = initializeSegments(MAX_ARRAY_SIZE, sourcefile, "f1.dat");

        merge(numberOfSegments, MAX_ARRAY_SIZE, "f1.dat", "f2.dat", "f3.dat", targetfile);
    }

    private static int initializeSegments(int segmentSize, String originalFile, String f1)
        throws Exception {
        int[] list = new int[segmentSize];
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));

        int numberOfSegments = 0;
        while (input.available() > 0) {
            numberOfSegments++;
            int i = 0;
            for ( ; input.available() > 0 && i < segmentSize; i++) {
                list[i] = input.readInt();
            }

            Arrays.sort(list, 0, i);

            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);
            }
        }

        input.close();
        output.close();
        return numberOfSegments;
    }

    private static void merge(int numberOfSegments, int segmentSize, String f1, String f2, String f3, String targetfile) 
        throws Exception {
        if (numberOfSegments > 1) {
            mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
            merge((numberOfSegments + 1) / 2, segmentSize * 2, f3, f1, f2, targetfile);
        }
        else {
            File sortedFile = new File(targetfile);
            if (sortedFile.exists()) sortedFile.delete();
            new File(f1).renameTo(sortedFile);
        }
    }

    private static void mergeOneStep(int numberOfSegments, int segmentSize, String f1, String f2, String f3)
        throws Exception {
        DataInputStream f1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
        DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));

        copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
        f2Output.close();

        DataInputStream f2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
        DataOutputStream f3Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));

        mergeSegments(numberOfSegments / 2, segmentSize, f1Input, f2Input, f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();
    }

    private static void copyHalfToF2(int numberOfSegments, int segmentSize, DataInputStream f1, DataOutputStream f2)
        throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());
        }
    }

    private static void mergeSegments(int numberOfSegments, int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3)
            throws Exception {
        for (int i = 0; i < numberOfSegments; i++) {
            mergeTwoSegments(segmentSize, f1, f2, f3);
        }

        while (f1.available() > 0) {
            f3.writeInt(f1.readInt());
        }
    }

    private static void mergeTwoSegments(int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3)
            throws Exception {
        int intFromF1 = f1.readInt();
        int intFromF2 = f2.readInt();
        int f1Count = 1;
        int f2Count = 1;

        while (true) {
            if (intFromF1 < intFromF2) {
                f3.writeInt(intFromF1);
                if (f1.available() == 0 || f1Count++ >= segmentSize) {
                    f3.writeInt(intFromF2);
                    break;
                }
                else {
                    intFromF1 = f1.readInt();
                }
            }
            else {
                f3.writeInt(intFromF2);
                if (f2.available() == 0 || f2Count++ >= segmentSize) {
                    f3.writeInt(intFromF1);
                    break;
                }
                else {
                    intFromF2 = f2.readInt();
                }
            }
        }

        while (f1.available() > 0 && f1Count++ < segmentSize) {
            f3.writeInt(f1.readInt());
        }

        while (f2.available() > 0 && f2Count++ < segmentSize) {
            f3.writeInt(f2.readInt());
        }
    }

    public static void displayFile(String filename) {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream(filename));
            for (int i = 0; i < 100; i++)
                System.out.print(input.readInt() + " ");
            input.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}