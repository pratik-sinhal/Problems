package program_O1_Heap;

/**
 * Created by pratik_s on 4/12/16.
 */
public interface IPriorityQueue<K> extends Iterable<K>{
    boolean isEmpty();
    int size();
    void heapify();
    K top();
    K deleteTop(); // same as extract top
    void insert(K key);
}
