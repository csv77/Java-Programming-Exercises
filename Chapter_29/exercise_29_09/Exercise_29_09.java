package exercise_29_09;

import exercise_29_06.WeightedEdge;
import exercise_29_06.WeightedGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_29_09 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        File file = new File(input.nextLine());
        
        try(Scanner in = new Scanner(file)) {
            int numberOfVertices = Integer.parseInt(in.nextLine());
            List<WeightedEdge> edges = new ArrayList<>();
            while(in.hasNext()) {
                String s = in.nextLine();
                String[] triplet = s.split("[\\|]");
                for(int i = 0; i < triplet.length; i++) {
                    String[] edge = triplet[i].split("[,]");
                    int u = Integer.parseInt(edge[0].trim());
                    int v = Integer.parseInt(edge[1].trim());
                    int w = Integer.parseInt(edge[2].trim());
                    edges.add(new WeightedEdge(u, v, w));
                    edges.add(new WeightedEdge(v, u, w));
                }
            }
            WeightedGraph g = new WeightedGraph(edges, numberOfVertices);
            g.printWeightedEdges();
            WeightedGraph.MST tree = g.getMinimumSpanningTree();
            System.out.println("The total weight in MST is " + tree.getTotalWeight());
            tree.printTree();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}
