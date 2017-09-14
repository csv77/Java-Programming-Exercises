package exercise_28_10;

import exercise_28_05.AbstractGraph;
import exercise_28_05.UnweightedGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_28_10 {

    public static void main(String[] args) {
        System.out.print("Enter a file name: ");
        Scanner input = new Scanner(System.in);
        String filename = input.nextLine();
        
        File file = new File(filename);
        
        System.out.print("Enter two vertices (integer indexes): ");
        int start = input.nextInt();
        int end = input.nextInt();
        
        ArrayList<AbstractGraph.Edge> edges = new ArrayList<>();
        int numberOfVertices = 0;
        
        try(Scanner in = new Scanner(file)) {
            if(in.hasNext()) {
                numberOfVertices = Integer.parseInt(in.nextLine());
            }
            while(in.hasNext()) {
                String s = in.nextLine();
                String[] array = s.split("[\\s+]");
                
                int u = Integer.parseInt(array[0]);
                for(int i = 1; i < array.length; i++) {
                    int v = Integer.parseInt(array[i]);
                    edges.add(new AbstractGraph.Edge(u, v));
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        catch (NumberFormatException ex) {
            System.out.println("Incorrect input data.");
        }
        
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, numberOfVertices);
        
        System.out.println("The number of vertices is " + graph.getSize());
        graph.printEdges();
        
        List<Integer> path = graph.getPath(start, end);
        if(path != null) {
            System.out.print("The path is ");
            for(Integer i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
