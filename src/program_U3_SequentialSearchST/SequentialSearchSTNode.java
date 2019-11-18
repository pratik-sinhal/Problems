package program_U3_SequentialSearchST;

/**
 * A sequential search symbol table node
 *
 * Created by pratik_s on 18/12/16.
 */
public class SequentialSearchSTNode<K,V> {
    public K key;
    public V value;
    public SequentialSearchSTNode<K,V> next;

    public SequentialSearchSTNode(K key, V value, SequentialSearchSTNode<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
