package exercise_28_14;

import exercise_28_13.TailModel;

public class Exercise_28_14 {

    public static void main(String[] args) {
        TailModel model = new TailModel();
        int numberOfVertices = model.tree.getNumberOfVerticesFound();
        System.out.println("The number of starting nodes that have a solution: " + numberOfVertices);
        System.out.println("The number of starting nodes that don't have a solution: " + (model.NUMBER_OF_NODES - numberOfVertices));
    }
}
