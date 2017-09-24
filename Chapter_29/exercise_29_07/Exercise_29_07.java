package exercise_29_07;

import exercise_29_06.WeightedTailModel16;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class Exercise_29_07 {

    public static void main(String[] args) {
        System.out.print("Enter an initial nine coins' Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        char[] initialNode = s.toCharArray();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("WeightedTailModel16.dat"))) {
            WeightedTailModel16 model = (WeightedTailModel16)(in.readObject());
            List<Integer> path = model.getShortestPath(WeightedTailModel16.getIndex(initialNode));

            System.out.println("The steps to flip the coins are ");
            for(int i = 0; i < path.size(); i++) {
                WeightedTailModel16.printNode(WeightedTailModel16.getNode(path.get(i)));    
            }

            System.out.println("The number of flips is " + model.getNumberOfFlips(WeightedTailModel16.getIndex(initialNode)));  
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        catch (IOException ex) {
            System.out.println("IO Exception");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Invalid class input");
        }
    }
}
