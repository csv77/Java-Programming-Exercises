package exercise_28_03;

import exercise_28_01.UnweightedGraph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V> {
    
    public UnweightedGraphWithNonrecursiveDFS() {
    }

    public UnweightedGraphWithNonrecursiveDFS(V[] vertices, int[][] edges) {
      super(vertices, edges);
    }

    public UnweightedGraphWithNonrecursiveDFS(List<V> vertices, List<Edge> edges) {
      super(vertices, edges);
    }

    public UnweightedGraphWithNonrecursiveDFS(List<Edge> edges, int numberOfVertices) {
      super(edges, numberOfVertices);
    }

    public UnweightedGraphWithNonrecursiveDFS(int[][] edges, int numberOfVertices) {
      super(edges, numberOfVertices);
    }
    
    @Override
    public Tree dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        
        boolean[] isVisited = new boolean[vertices.size()];
        
        stack.push(v);
        isVisited[v] = true;
        searchOrder.add(v);
        
        while(!stack.isEmpty()) {
            int x = stack.peek();
            int index = unvisitedNeighbor(neighbors.get(x), isVisited);
            if(index != -1) {
                Edge e = neighbors.get(x).get(index);
                stack.push(e.v);
                searchOrder.add(e.v);
                parent[e.v] = x;
                isVisited[e.v] = true;
            }
            else {
                stack.pop();
            }
        }
        
        return new Tree(v, parent, searchOrder);
    }
    
    private int unvisitedNeighbor(List<Edge> neighborEdges, boolean[] isVisited) {
        for(Edge e : neighborEdges) {
            if(!isVisited[e.v]) {
                return neighborEdges.indexOf(e);
            }
        }
        return -1;
    }
}
