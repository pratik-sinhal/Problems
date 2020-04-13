package GRAPH.program_N21_EdgeWeightedDiGraph;

/**
 * Created by pratik on 1/9/17.
 */
public interface IGraphWeighted {
    Integer V();
    Integer E();
    void addEdge(Integer u, Integer v, Double w);

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IndexOutOfBoundsException unless {@code 0 <= v < V}
     */
    Iterable<Edge> adjacents(Integer v);
}
