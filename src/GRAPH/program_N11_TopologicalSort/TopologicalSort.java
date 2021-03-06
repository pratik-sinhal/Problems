package GRAPH.program_N11_TopologicalSort;

import GRAPH.program_N13_Graph.Graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by pratik on 12/7/17.
 */
public class TopologicalSort {
    private Boolean[] marked;
    private Stack<Integer> reversePostOrder;
    private Integer[] rank;

    public TopologicalSort(Graph G) {
        marked = new Boolean[G.V()];
        rank = new Integer[G.V()];
        reversePostOrder = new Stack<>();

        Arrays.fill(marked, false);

        //TODO: [IMP] check if di-graph does not have a cycle before proceeding
        for (int i=0; i< G.V(); ++i) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
        int i=0;
        for (int v :reversePostOrder) {
            rank[v] = i++;
        }
    }

    public Boolean hasOrder() {
        //TODO: to be implemented
        return true;
    }

    public Iterable<Integer> order() {
        return reversePostOrder;
    }

    public int rank(Integer v) {
        validateVertex(v);
        if(hasOrder())
            return rank[v];
        return -1;
    }

    public Boolean isDAG() {
        return hasOrder();
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int i : G.adjacents(s)) {
            if(!marked[i]) {
                dfs(G, i);
            }
        }
        reversePostOrder.push(s);
    }

    private void validateVertex(Integer v) {
        int V = marked.length;
        if(v<0 || v>=V) {
            throw new IllegalArgumentException();
        }
    }
}
