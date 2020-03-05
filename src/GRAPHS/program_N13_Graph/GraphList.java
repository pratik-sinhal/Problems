package GRAPHS.program_N13_Graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik_s on 11/10/16.
 */
public class GraphList implements IGraph {
    private final Integer V; // num of vertices
    private Integer E; // num of edges
    private Boolean directed;
    private List<Integer>[] adj; // adjacents of a node

    /**
     * Done
     * @param V
     */
    public GraphList(int V, boolean directed) {
        if(V < 0)
            throw new IllegalArgumentException("no of vertices in a graph must be non negative");
        this.V = V;
        this.E = 0;
        this.directed = directed;
        this.adj = (List<Integer>[]) new List[V];
        // initialize each index of the adjacent array
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public GraphList(int V) {
        this(V, false);
    }

    /**
     * Done
     * O(1)
     * @return
     */
    @Override
    public Integer V() {
        return V;
    }

    /**
     * Done
     * O(1)
     * @return
     */
    @Override
    public Integer E() {
        return E;
    }

    /**
     * Done
     * @param u
     * @param v
     */
    @Override
    public void addEdge(Integer u, Integer v) {
        validateVertex(u);
        validateVertex(v);
        ++E;
        adj[u].add(v);
        if(!directed) {
            adj[v].add(u);
        }
    }

    /**
     * Done
     * O(1)
     * @param  v the vertex
     * @return
     */
    @Override
    public Iterable<Integer> adjacents(Integer v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Done
     * O(1)
     * @return
     */
    @Override
    public Integer degree(Integer v) {
        validateVertex(v);
        return adj[v].size();
    }

    public List<Integer>[] getAdjacents() {
        return adj;
    }

    @Override
    public String toString(){
        return null;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

}
