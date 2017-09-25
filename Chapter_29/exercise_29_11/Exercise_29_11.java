package exercise_29_11;

import exercise_29_06.WeightedEdge;
import exercise_29_06.WeightedGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_29_11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        File file = new File(input.nextLine());
        System.out.print("Enter two vetices (integer indexes): ");
        int i1 = input.nextInt();
        int i2 = input.nextInt();
        
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
            WeightedGraph.ShortestPathTree tree = g.getShortestPath(i2);
            List<Integer> path = tree.getPath(i1);
            System.out.print("A path from " + i1 + " to " + i2 + ":");
            for(Integer i : path) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }
}
