package GRAPHS.program_N13_Graph;

/**
 * Created by pratik_s on 11/10/16.
 */
public class Graph {

    private IGraph graph;

    public Graph(IGraph graph) {
        this.graph = graph;
    }

    public Integer V() {
        return graph.V();
    }

    public Iterable<Integer> adjacents(Integer v) {
        return graph.adjacents(v);
    }

    public Integer E() {
        return graph.E();
    }

    public void addEdge(Integer u, Integer v) {
        graph.addEdge(u, v);
    }

    public Integer degree(Integer v) {
        return graph.degree(v);
    }
}
