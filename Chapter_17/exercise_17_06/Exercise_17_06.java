package exercise_17_06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Exercise_17_06 {

    public static void main(String[] args) {
        try {
            try(ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Chapter_17/Exercise17_06.dat")))) {
                for(int i = 0; i < 5;  i++) {
                    output.writeObject(new Loan(6.25, (int)(Math.random() * 20) + 1, 1000 + Math.random() * 20000));
                }
            }
            
            try(ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Chapter_17/Exercise17_06.dat")))) {
                while(true) {
                    Loan newLoan = (Loan)input.readObject();
                    System.out.println(newLoan);
                }
            }
        }
        catch(EOFException e) {
            System.out.println("All Loan objects were read");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
            
    }
    
}
