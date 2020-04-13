package HEAPS.HeapImplementation;

import java.util.Iterator;

/**
 * Created by pratik_s on 4/12/16.
 */
public class PriorityQueue<K> {
    IPriorityQueue<K> heap;

    public PriorityQueue(IPriorityQueue<K> heap) {
        this.heap = heap;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void heapify() {
        heap.heapify();
    }

    public void insert(K key) {
        heap.insert(key);
    }

    public K deleteTop() {
        return heap.deleteTop();
    }

    public Iterator<K> iterator() {
        return heap.iterator();
    }

    public K top() {
        return heap.top();
    }
}
