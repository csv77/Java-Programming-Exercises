package exercise_28_13;

import java.util.List;
import java.util.Scanner;

public class Exercise_28_13 {

    public static void main(String[] args) {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        char[] initialNode = s.toCharArray();

        TailModel model = new TailModel();
        List<Integer> path = model.getShortestPath(TailModel.getIndex(initialNode));
        if(path != null) {
            System.out.println("The steps to flip the coins are ");
            for (int i = 0; i < path.size(); i++) {
                TailModel.printNode(TailModel.getNode(path.get(i)));  
            }
        }
        else {
            System.out.println("Cannot find any path from this node.");
        }
    }
}
