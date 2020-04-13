package GRAPH.program_N21_EdgeWeightedDiGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik on 1/9/17.
 */
public class GraphListWeighted implements IGraphWeighted {

    private final Integer V;
    private Integer E;
    private Boolean directed;
    private List<Edge>[] adj;

    public GraphListWeighted(Integer v, Boolean directed) {
        this.V = v;
        this.E = 0;
        this.directed = directed;
        this.directed = directed;
        this.adj = (List<Edge>[]) new Object[V()];
        for (int i = 0; i < V(); i++) {
            adj[i] = new ArrayList<Edge>();
        }
    }

    @Override
    public Integer V() {
        return V;
    }

    @Override
    public Integer E() {
        return E;
    }

    @Override
    public void addEdge(Integer u, Integer v, Double w) {
        adj[u].add(new Edge(u,v,w));
        if(!directed){
            adj[v].add(new Edge(v,u,w));
        }
        ++E;
    }

    @Override
    public Iterable<Edge> adjacents(Integer v) {
        return adj[v];
    }
}
