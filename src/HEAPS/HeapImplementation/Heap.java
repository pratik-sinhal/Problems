package HEAPS.HeapImplementation;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by pratik_s on 4/12/16.
 */
public class Heap<K> implements IPriorityQueue<K> {
    private K[] pq; //
    // store items at indices starting at 1
    private int n;
    private Comparator<K> comparator;

    public Heap(K[] keys, Comparator<K> comparator) {
        this.comparator = comparator;
        this.n = keys.length;
        this.pq = (K[]) new Object[keys.length+1]; // +1 since array is 1-indexed
        for (int i = 0; i < keys.length; i++) {
            pq[i+1] = keys[i];
        }
        heapify();
    }

    public Heap(K[] pq) {
        this(pq, null);
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public K top() {
        checkEmpty();
        return pq[1];
    }

    private void checkEmpty() {
        if(isEmpty())
            throw new NoSuchElementException("Priority queue underflow");
    }

    @Override
    public void heapify() {
        for (int i = n/2; i >= 1; i--) {
            sink(i);
        }
    }

    private void sink(int i) {
        while(i<<1 <= n){ // while there is element to the left to be compared
            int j=i*2;
            // if i has both left & right child, compare them first
            if(j<n && less(j,j+1))
                j++;
            // compare greater of two child with i
            if(!less(i,j))
                break;
            swap(i,j);
            i=j;
        }
    }

    private void swap(int i, int j) {
        K temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {
        if(comparator != null) {
            return comparator.compare(pq[i], pq[j]) < 0;
        } else {
            return ((Comparable<K>) pq[i]).compareTo(pq[j]) < 0;
        }
    }

    @Override
    public K deleteTop() {
        checkEmpty();
        K top = pq[1];
        swap(1,n);
        pq[n--] = null;
        sink(1);
        if(n>0 && n==(pq.length-1)/4)
            resize(pq.length>>1);
        return top;
    }

    @Override
    public void insert(K key) {
        if(n == pq.length-1)
            resize(pq.length<<1);
        pq[++n] = key;
        swim(n);
    }

    private void swim(int i) {
        while(i>1 && less(i>>1,i)){
            swap(i>>1,i);
            i=i>>1;
        }
    }

    private void resize(int capacity) {
        K[] temp = (K[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    @Override
    public Iterator<K> iterator() {
        return this.new HeapIterator();
    }

    private class HeapIterator implements Iterator<K> {

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public K next() {
            if(!hasNext())
                throw new NoSuchElementException();
            return deleteTop();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer t1, Integer t2) {
            return t1-t2;
        }
    }
}
