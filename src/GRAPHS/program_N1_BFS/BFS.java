package GRAPHS.program_N1_BFS;

import GRAPHS.program_N13_Graph.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pratik on 2/7/17.
 */
public class BFS {
    private Boolean[] marked;
    private Integer[] edgeTo;
    private Integer[] distanceTo;

    public BFS(Graph G, Integer s) {
        marked = new Boolean[G.V()];
        edgeTo = new Integer[G.V()];
        distanceTo = new Integer[G.V()];
        validateVertex(s);
        processBFS(G,s);
    }

    public Boolean hasPathTo(Integer v) {
        validateVertex(v);
        return marked[v];
    }

    public Integer distanceTo(Integer v) {
        validateVertex(v);
        return distanceTo[v];
    }

    public Iterable<Integer> pathTo(Integer v) {
        validateVertex(v);
        // does not have path if the vertex is not marked
        if(!hasPathTo(v))
            return null;
        Integer u = v;
        Stack<Integer> path = new Stack<Integer>();
        while (u != null) {
            path.push(u);
            u = edgeTo[u];
        }
        return path;
    }

    private void processBFS(Graph G, Integer s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        distanceTo[s] = 0;
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()){
            Integer u = queue.remove();
            for (Integer i : G.adjacents(u)) {
                if(!marked[i]) {
                    edgeTo[i] = u;
                    marked[i] = true;
                    distanceTo[i] = distanceTo[u] + 1;
                    queue.add(i);
                }
            }
        }
    }

    private void validateVertex(Integer v) {
        int V = marked.length;
        if(v<0 || v>=V) {
            throw new IllegalArgumentException();
        }
    }
}
