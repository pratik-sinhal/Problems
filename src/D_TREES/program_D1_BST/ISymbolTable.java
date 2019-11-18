package D_TREES.program_D1_BST;

/**
 * Created by pratik_s on 25/9/16.
 * Bridge design pattern - Interface/body
 */
public interface ISymbolTable<K, V> {
    Boolean isEmpty();
    Integer size();
    Boolean contains(K key);
    V get(K key);
    void put(K key, V value);
    void deleteMin();
    void deleteMax();
    void delete(K key);
    K min();
    K max();

    /**
     * Returns the largest key in the symbol table less than or equal to key
     * @param key
     * @return
     */
    K floor(K key);  // to be revised

    /**
     * Returns the smallest key in the symbol table greater than or equal to key
     * @param key
     * @return
     */
    K ceiling(K key);

    /**
     * Return the kth smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the kth smallest key in the symbol table
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>N</em> &minus; 1
     */
    K select(Integer k);

    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     *
     * @param  key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws NullPointerException if {@code key} is {@code null}
     */
    Integer rank(K key);

    Iterable<K> keys();
    Iterable<K> keys(K low, K high);

    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @param  low minimum endpoint
     * @param  high maximum endpoint
     * @return the number of keys in the symbol table between {@code lo}
     *         (inclusive) and {@code hi} (inclusive)
     * @throws NullPointerException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    Integer size(K low, K high);

    /**
     * Returns the height of the SymbolTable (for debugging).
     *
     * @return the height of the SymbolTable (a 1-node tree has height 0)
     */
    Integer height();

    /**
     * Returns the keys in the SymbolTable in level order (for debugging).
     *
     * @return the keys in the SymbolTable in level order traversal
     */
    Iterable<K> levelOrder();

    void printPaths();

    boolean isBST(); // to be revised
}
