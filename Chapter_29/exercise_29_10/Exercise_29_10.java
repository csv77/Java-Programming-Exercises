package exercise_29_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exercise_29_10 {

    public static void main(String[] args) {
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles",
            "Denver", "Kansas City", "Chicago", "Boston", "New York",
            "Atlanta", "Miami", "Dallas", "Houston"};

        int[][] edges = {
            {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
            {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
            {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
            {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599}, {3, 5, 1003},
            {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260}, {4, 8, 864}, {4, 10, 496},
            {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533}, {5, 6, 983}, {5, 7, 787},
            {6, 5, 983}, {6, 7, 214},
            {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
            {8, 4, 864}, {8, 7, 888}, {8, 9, 661}, {8, 10, 781}, {8, 11, 810},
            {9, 8, 661}, {9, 11, 1187},
            {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
            {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
        };

        try(PrintWriter output = new PrintWriter(new File("WeightedGraphSample2.txt"))) {
            output.println(vertices.length + "");
            for(int i = 0; i < vertices.length; i++) {
                int count = 0;
                for(int j = 0; j < edges.length; j++) {
                    if(edges[j][0] == i && edges[j][0] < edges[j][1]) {
                        if(count == 0) {
                            output.print(edges[j][0] + ", " + edges[j][1] + ", " + edges[j][2]);
                        }
                        else {
                            output.print(" | " + edges[j][0] + ", " + edges[j][1] + ", " + edges[j][2]);
                        }
                        count++;
                    }
                }
                if(i < vertices.length - 1) {
                    output.println();
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}
