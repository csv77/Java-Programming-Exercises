package exercise_29_06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Exercise_29_06 {

    public static void main(String[] args) {
        WeightedTailModel16 model = new WeightedTailModel16();

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("WeightedTailModel16.dat"))) {
            output.writeObject(model);
            System.out.println("The file WeightedTailModel16.dat is done.");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("IO Exception");
        }
    }
}
