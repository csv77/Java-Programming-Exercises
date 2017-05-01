package exercise_17_05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Exercise_17_05 {

    public static void main(String[] args) {
        int[] intValues = {1, 2, 3, 4, 5};
        Date date = new Date();
        double doubleValue = 5.5;
        try {
            try(ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Chapter_17/Exercise17_05.dat")))) {
                output.writeObject(intValues);
                output.writeObject(date);
                output.writeDouble(doubleValue);
            }
            
            try(ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Chapter_17/Exercise17_05.dat")))) {
                int[] newIntValues = (int[])input.readObject();
                Date newDate = (Date)input.readObject();
                double newDoubleValue = input.readDouble();
                for(int i : newIntValues) {
                    System.out.print(i + " ");
                }
                System.out.println("\n" + newDate + "\n" + newDoubleValue);
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
