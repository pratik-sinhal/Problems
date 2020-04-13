package GRAPH.program_N13_Graph;

/**
 * Created by pratik_s on 11/10/16.
 */
public interface IGraph {
    Integer V();
    Integer E();
    void addEdge(Integer u, Integer v);

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IndexOutOfBoundsException unless {@code 0 <= v < V}
     */
    Iterable<Integer> adjacents(Integer v);

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IndexOutOfBoundsException unless {@code 0 <= v < V}
     */
    Integer degree(Integer v);
}
