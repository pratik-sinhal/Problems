package GRAPHS.program_N21_EdgeWeightedDiGraph;


/**
 * Created by pratik_s on 11/10/16.
 */

public class Edge implements Comparable<Edge>{
    public Integer u, v;
    public double weight;

    public Edge(Integer u, Integer v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int either() {
        return u;
    }

    public int other(int v) {
        if(this.v == v)
            return u;
        return v;
    }

    public double weight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        if(this.weight < edge.weight) return -1;
        else if(this.weight > edge.weight) return 1;
        else return 0;
    }
}
