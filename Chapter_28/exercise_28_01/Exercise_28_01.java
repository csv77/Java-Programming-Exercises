package exercise_28_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_28_01 {

    public static void main(String[] args) {
        System.out.print("Enter a file name: ");
        File file = new File(new Scanner(System.in).nextLine());
        
        ArrayList<AbstractGraph.Edge> list = new ArrayList<>();
        int numberOfVertices = 0;
        
        try(Scanner input = new Scanner(file)) {
            if(input.hasNext()) {
                numberOfVertices = Integer.parseInt(input.nextLine());
            }
            while(input.hasNext()) {
                String s = input.nextLine();
                String[] array = s.split("[\\s+]");
                
                int u = Integer.parseInt(array[0]);
                for(int i = 1; i < array.length; i++) {
                    int v = Integer.parseInt(array[i]);
                    list.add(new AbstractGraph.Edge(u, v));
                }
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        catch (NumberFormatException ex) {
            System.out.println("Incorrect input data.");
        }
        
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(list, numberOfVertices);
        
        System.out.println("The number of vertices is " + graph.getSize());
        
        graph.printEdges();
        
        AbstractGraph.Tree tree = graph.dfs(0);
        
        if(tree.getNumberOfVerticesFound() == graph.getSize()) {
            System.out.println("The graph is connected.");
        }
        else {
            System.out.println("The graph is not connected.");
        }
    }
}
