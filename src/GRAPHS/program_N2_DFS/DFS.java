package GRAPHS.program_N2_DFS;

import GRAPHS.program_N13_Graph.Graph;

/**
 * Created by pratik on 3/7/17.
 */
public class DFS {
    private Boolean[] marked;
    private Integer count; // no. of vertices connected to source

    public DFS(Graph G, Integer s) {
        marked = new Boolean[G.V()];
        validateVertex(s);
        dfs(G,s);
    }

    public Boolean hasPathTo(Integer v) {
        validateVertex(v);
        return marked[v];
    }

    public Integer count(){
        return count;
    }

    private void dfs(Graph G, Integer s) {
        marked[s] = true;
        for(int i: G.adjacents(s)){
            if(!marked[i]){
                ++count;
                dfs(G,i);
            }
        }
        return;
    }

    private void validateVertex(Integer v) {
        int V = marked.length;
        if(v<0 || v>=V) {
            throw new IllegalArgumentException();
        }
    }
}
