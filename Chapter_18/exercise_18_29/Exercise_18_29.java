package exercise_18_29;

import java.io.File;
import java.util.Scanner;

public class Exercise_18_29 {

    public static void main(String[] args) {
        System.out.print("Enter a directory: ");    
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();
    
        System.out.println(getNumber(new File(directory)) + " files");
    }

    public static long getNumber(File file) {
        long numberOfFiles = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                numberOfFiles += getNumber(files[i]);
            }
        }
        else {
            return 1;
        }

        return numberOfFiles;
    }
    
}
