package T_UNIONFIND.program_T1_UnionFind;

import lombok.Data;

/**
 * Created by pratik_s on 18/9/16.
 */
@Data
public class UnionFindNode {
    public Integer root; // root of i
    public Integer rank; // rank of subtree rooted at i

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
