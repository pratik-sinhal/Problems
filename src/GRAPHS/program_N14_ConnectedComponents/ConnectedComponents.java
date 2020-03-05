package GRAPHS.program_N14_ConnectedComponents;

import GRAPHS.program_N13_Graph.Graph;

/**
 * Created by pratik on 12/7/17.
 */
public class ConnectedComponents {
    private Boolean[] marked;
    private Integer[] id; // id[v] = id the CC containing v
    private Integer[] size; // size[id] = no of vertices in given component
    private Integer count; // no. of CC

    public ConnectedComponents(Graph G) {
        marked = new Boolean[G.V()];
        id = new Integer[G.V()];
        size = new Integer[G.V()];
        count = 0;
        for (int i=0; i<= G.V(); ++i) {
            if (!marked[i]) {
                ++count;
                dfs(G, i);
            }
        }
    }

    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    public int count() {
        return count;
    }

    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        id[s] = count;
        ++size[count];
        for (int i : G.adjacents(s)) {
            if(!marked[i]) {
                dfs(G, i);
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
