package exercise_28_04;

import exercise_28_01.UnweightedGraph;
import java.util.ArrayList;
import java.util.List;

public class MyGraph<V> extends UnweightedGraph<V> {

    public MyGraph() {
    }

    public MyGraph(V[] vertices, int[][] edges) {
        super(vertices, edges);
    }

    public MyGraph(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    public MyGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    public MyGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }
    
    public List<List<Integer>> getConnectedComponents() {
        List<List<Integer>> listOfConnectedComponents = new ArrayList<>();
        
        List<Integer> vertexIndices = new ArrayList<>();
        for(int i = 0; i < vertices.size(); i++) {
            vertexIndices.add(i);
        }
        
        while(vertexIndices.size() > 0) {
            Tree dfs = super.dfs(vertexIndices.get(0));
            listOfConnectedComponents.add(dfs.getSearchOrder());
            vertexIndices.removeAll(dfs.getSearchOrder());
        }
        
        return listOfConnectedComponents;
    }
}
