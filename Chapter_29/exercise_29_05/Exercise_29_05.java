package exercise_29_05;

import exercise_28_05.AbstractGraph.Tree;
import exercise_28_11.NineTailModel;
import exercise_29_04.WeightedNineTailModel;

public class Exercise_29_05 {

    public static void main(String[] args) {
        Tree tree1 = new NineTailModel().getTree();
        Tree tree2 = new WeightedNineTailModel().getTree();
        
        for(int i = 0; i < 511; i++) {
            int depth1 = tree1.getPath(i).size();
            int depth2 = tree2.getPath(i).size();
            if(depth1 != depth2) {
                System.out.println("The 2 shortest path are different.");
                return;
            }
        }
        System.out.println("The 2 shortest path are the same.");
    }
}
