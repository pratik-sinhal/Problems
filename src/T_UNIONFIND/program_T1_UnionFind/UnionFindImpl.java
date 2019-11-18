package T_UNIONFIND.program_T1_UnionFind;

/**
 * Created by pratik_s on 12/9/16.
 */
public class UnionFindImpl implements IUnionFind {
    private Integer count; // no of components
    private UnionFindNode[] nodes; // array of node data

    public Integer getCount() {
        return count;
    }

    /**
     * Theta(count)
     * @param count
     */
    public UnionFindImpl(Integer count) {
        this.count = count;
        nodes = new UnionFindNode[count];
        for (int i = 0; i < count; i++) {
            nodes[i] = new UnionFindNode();
            nodes[i].setRoot(i);
            nodes[i].setRank(0);
        }
    }

    @Override
    public Integer find(Integer p) {
        validate(p);
        UnionFindNode nodeP = nodes[p];
        Integer rootP = nodeP.getRoot();
        if(rootP == p)
            return p;
        rootP = find(rootP);
        nodeP.setRoot(rootP);
        return rootP;
    }

    @Override
    public void union(Integer p, Integer q) {
        validate(p);
        validate(q);

        Integer rootP = find(p);
        Integer rootQ = find(q);

        if(rootP == rootQ)
            return;

        // make ROOT of smaller rank point to ROOT of larger rank
        UnionFindNode nodeP = nodes[rootP];
        UnionFindNode nodeQ = nodes[rootQ];
        Integer rankP = nodeP.getRank();
        Integer rankQ = nodeQ.getRank();
        if(rankP < rankQ) {
            nodeP.setRoot(rootQ);
        } else if(rankP > rankQ) {
            nodeQ.setRoot(rootP);
        } else {
            nodeP.setRoot(rootQ);
            nodeQ.setRank(rankQ + 1);
        }
        --count; // imp. need to decrease the no of components by 1
    }

    @Override
    public Boolean connected(Integer p, Integer q) {
        return find(p) == find(q);
    }

    private void validate(Integer p) {
        if(p < 0 || p >= nodes.length) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and "
                    + (nodes.length - 1));
        }

    }
}
