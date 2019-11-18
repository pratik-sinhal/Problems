package T_UNIONFIND.program_T1_UnionFind;

/**
 * Created by pratik_s on 12/9/16.
 * The time complexity of each operations becomes even smaller than O(log n).
 * In fact, amortized time complexity effectively becomes small constant.
 */
public interface IUnionFind {
    Integer find(Integer p);
    void union(Integer p, Integer q);
    Boolean connected(Integer p, Integer q);
}
