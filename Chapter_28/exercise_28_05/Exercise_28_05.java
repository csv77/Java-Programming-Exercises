package exercise_28_05;

import java.util.List;

public class Exercise_28_05 {

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
        
        UnweightedGraph<Integer> graph1 = new UnweightedGraph<>(edges, numberOfVertices);
        List<Integer> path = graph1.getPath(1, 4);
        
        System.out.println(path == null ? "There are no path between these indices." : "The path is: " + path);
        
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
            "Denver", "Kansas City", "Chicago", "Boston", "New York",
            "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges2 = {
            {0, 1}, {0, 3}, {0, 5},
            {1, 0}, {1, 2}, {1, 3},
            {2, 1}, {2, 3}, {2, 4}, {2, 10},
            {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
            {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
            {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
            {6, 5}, {6, 7},
            {7, 4}, {7, 5}, {7, 6}, {7, 8},
            {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
            {9, 8}, {9, 11},
            {10, 2}, {10, 4}, {10, 8}, {10, 11},
            {11, 8}, {11, 9}, {11, 10}
        };

        UnweightedGraph<String> graph2 = new UnweightedGraph<>(vertices, edges2);
        path = graph2.getPath(9, 4);
        
        System.out.println(path == null ? "There are no path between these indices." : "The path is: " + path);
    }
}
