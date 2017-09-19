package exercise_28_12;

import java.util.List;
import java.util.Scanner;

public class Exercise_28_12 {

    public static void main(String[] args) {
        System.out.print("Enter the initial nine coins Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine(); 
        char[] initialNode = s.toCharArray();

        NineTailModel model = new NineTailModel();
        List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are ");
        for (int i = 0; i < path.size(); i++) {
            NineTailModel.printNode(NineTailModel.getNode(path.get(i)));  
        }
    }
}
