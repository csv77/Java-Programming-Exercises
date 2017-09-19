package exercise_28_13;

import java.util.List;
import java.util.Scanner;

public class Exercise_28_13 {

    public static void main(String[] args) {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        char[] initialNode = s.toCharArray();

        NineTailModel4By4 model = new NineTailModel4By4();
        List<Integer> path = model.getShortestPath(NineTailModel4By4.getIndex(initialNode));
        if(path != null) {
            System.out.println("The steps to flip the coins are ");
            for (int i = 0; i < path.size(); i++) {
                NineTailModel4By4.printNode(NineTailModel4By4.getNode(path.get(i)));  
            }
        }
        else {
            System.out.println("Cannot find any path from this node.");
        }
    }
}
