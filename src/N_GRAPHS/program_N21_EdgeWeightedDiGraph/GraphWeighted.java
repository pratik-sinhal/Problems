package N_GRAPHS.program_N21_EdgeWeightedDiGraph;

/**
 * Created by pratik on 1/9/17.
 */
public class GraphWeighted {
    private IGraphWeighted iGraphWeighted;

    public GraphWeighted(IGraphWeighted iGraphWeighted) {
        this.iGraphWeighted = iGraphWeighted;
    }

    public Integer V() {
        return iGraphWeighted.V();
    }

    public Integer E() {
        return iGraphWeighted.E();
    }

    public void addEdge(Integer u, Integer v, Double w) {
        iGraphWeighted.addEdge(u, v, w);
    }

    public Iterable<Edge> adjacents(Integer v) {
        return iGraphWeighted.adjacents(v);
    }

    public Iterable<Edge> edges(Integer v) {
        return null;//iGraphWeighted.edges(v);
    }
}
