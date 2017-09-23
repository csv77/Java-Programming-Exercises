package exercise_28_13;

import exercise_28_05.AbstractGraph;
import exercise_28_05.AbstractGraph.Edge;
import exercise_28_05.UnweightedGraph;
import java.io.Serializable;
import java.util.*;

public class TailModel implements Serializable{
    public final static int DIMENSION = 4;
    public final static int NUMBER_OF_NODES = 1 << DIMENSION * DIMENSION;
    public UnweightedGraph<Integer>.Tree tree;

    public TailModel() {
        List<AbstractGraph.Edge> edges = getEdges();

        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, NUMBER_OF_NODES); 

        tree = graph.bfs(NUMBER_OF_NODES - 1);
    }

    private List<AbstractGraph.Edge> getEdges() {
        List<Edge> edges = new ArrayList<Edge>();

        for(int u = 0; u < NUMBER_OF_NODES; u++) {
            for(int k = 0; k < DIMENSION * DIMENSION; k++) {
                char[] node = getNode(u);
                if(node[k] == 'H') {
                    int v = getFlippedNode(node, k);
                    edges.add(new AbstractGraph.Edge(v, u));
                }
            }
        }

        return edges;
    }

    public static int getFlippedNode(char[] node, int position) {
        int row = position / DIMENSION;
        int column = position % DIMENSION;

        flipACell(node, row, column);
        flipACell(node, row - 1, column);
        flipACell(node, row + 1, column);
        flipACell(node, row, column - 1);
        flipACell(node, row, column + 1);

        return getIndex(node);
    }

    public static void flipACell(char[] node, int row, int column) {
        if(row >= 0 && row < DIMENSION && column >= 0 && column < DIMENSION) { 
            if(node[row * DIMENSION + column] == 'H') {
                node[row * DIMENSION + column] = 'T';
            }
            else {
                node[row * DIMENSION + column] = 'H';
            }
        }
    }

    public static int getIndex(char[] node) {
        int result = 0;

        for(int i = 0; i < DIMENSION * DIMENSION; i++)
            if(node[i] == 'T') {
                result = result * 2 + 1;
            }
            else {
                result = result * 2 + 0;
            }

        return result;
    }

    public static char[] getNode(int index) {
        char[] result = new char[DIMENSION * DIMENSION];

        for(int i = 0; i < result.length; i++) {
            int digit = index % 2;
            if(digit == 0) {
                result[DIMENSION * DIMENSION - 1 - i] = 'H';
            }
            else {
                result[DIMENSION * DIMENSION - 1 - i] = 'T';
            }
            index = index / 2;
        }

        return result;
    }

    public List<Integer> getShortestPath(int nodeIndex) {
        List<Integer> path = tree.getPath(nodeIndex);
      
        if (path.size() == 1 && path.get(0) != DIMENSION * DIMENSION - 1) {
            return null;
        }
        else {
            return path;
        }
    }

    public static void printNode(char[] node) {
        for(int i = 0; i < DIMENSION * DIMENSION; i++)
            if(i % DIMENSION != DIMENSION - 1) {
                System.out.print(node[i]);
            }
            else {
                System.out.println(node[i]);
            }

        System.out.println();
    }
}
