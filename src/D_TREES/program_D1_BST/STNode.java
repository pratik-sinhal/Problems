package D_TREES.program_D1_BST;

import lombok.Data;

/**
 * A symbol table node
 *
 * Created by pratik_s on 25/9/16.
 */
@Data
/**
 * Done
 */
public class STNode<K, V> {
    public K key;                  // sorted by key
    public V value;                // associated data
    public STNode<K,V> left, right;    // left & right subtrees
    public Integer size;           // no of nodes in subtree



    public STNode(K key, V value, Integer size) {
        this.key = key;
        this.value = value;
        this.size = size;
    }
}
