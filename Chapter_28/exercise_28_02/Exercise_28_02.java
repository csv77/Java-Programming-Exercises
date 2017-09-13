package exercise_28_02;

import exercise_28_01.Graph;
import exercise_28_01.UnweightedGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Exercise_28_02 {

    public static void main(String[] args) {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
            "Denver", "Kansas City", "Chicago", "Boston", "New York",
            "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges = {
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

        Graph<String> graph1 = new UnweightedGraph<>(vertices, edges);
        
        File file = new File("GraphSample3.txt");
        try(PrintWriter output = new PrintWriter(file)) {
            output.println(vertices.length);
            for(int i = 0; i < vertices.length; i++) {
                List<Integer> list = graph1.getNeighbors(i);
                output.print(i + " ");
                int k = 0;
                for(Integer j : list) {
                    if(k < list.size() - 1) {
                        output.print(j + " ");
                    }
                    else {
                        output.print(j);
                    }
                    k++;
                }
                if(i < vertices.length - 1) {
                    output.println();
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
    }
}
