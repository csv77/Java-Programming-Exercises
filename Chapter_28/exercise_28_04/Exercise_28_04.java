package exercise_28_04;

public class Exercise_28_04 {

    public static void main(String[] args) {
        int numberOfVertices = 6;
        int[][] edges = {
            {0, 1}, {0, 2}, {0, 3},
            {1, 0}, {1, 3},
            {2, 0}, {2, 3},
            {3, 0}, {3, 1}, {3, 2},
            {4, 5},
            {5, 4}
        };
        
        MyGraph<Integer> graph = new MyGraph<Integer>(edges, numberOfVertices);
        System.out.println(graph.getConnectedComponents());
    }
}
