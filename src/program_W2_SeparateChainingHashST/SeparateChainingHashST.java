package program_W2_SeparateChainingHashST;

import program_G2_Queue.QueueList;
import program_U3_SequentialSearchST.SequentialSearchST;
import TREES.BST.ISymbolTable;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by pratik_s on 18/12/16.
 */
public class SeparateChainingHashST<K extends Comparable<K>,V> implements ISymbolTable<K,V> {


    private Integer m;          // size of hash table
    private Integer n;          // no. of key-value pairs in the hash table
    private SequentialSearchST<K,V>[] st; // array of key-value linked list symbol table

    private static final int INITIAL_CAPACITY = 4;
    private static final int MAX_AVERAGE_LENGTH_OF_LIST = 10;
    private static final int MIN_AVERAGE_LENGTH_OF_LIST = 2;

    public SeparateChainingHashST() {
        this(INITIAL_CAPACITY);
    }

    public SeparateChainingHashST(Integer capacity){
        this.m = capacity;
        st = (SequentialSearchST<K,V>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<K, V>();
        }
    }

    @Override
    public Boolean isEmpty() {
        return size()==0;
    }

    @Override
    public Integer size() {
        return n;
    }

    @Override
    public Boolean contains(K key) {
        checkKey(key);
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        checkKey(key);
        checkEmpty();

        int i = hash(key);
        return st[i].get(key);
    }

    @Override
    public void put(K key, V value) {
        checkKey(key);

        if(value == null){
            delete(key);
            return;
        }

        // double capacity if average length of list is high
        if(n >= MAX_AVERAGE_LENGTH_OF_LIST*m){
            resize(m<<1);
        }

        int i = hash(key);
        if(!st[i].contains(key)){
            ++n;
        }
        st[i].put(key, value);
    }

    // hash value between 0 and m-1
    // doing a bit mask to ensure number is always positive
    // 0x7fffffff is max int value in java
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % m;
        // return key.hashCode() & (m-1)
        // above statement is best leveraged if m is a power of two
    }

    /**
     * rehashing all the keys in the hash table
     * @param chains
     */
    private void resize(int chains) {
        SeparateChainingHashST<K, V> tempST = new SeparateChainingHashST<K, V>(chains);
        for (int i = 0; i < m; i++) {
            Iterable<K> keys = st[i].keys();
            if(!((Collection<K>)keys).isEmpty()){
                for (K key : keys) {
                    tempST.put(key, st[i].get(key));
                }
            }
        }
        this.m = tempST.m;
        this.n = tempST.n;
        this.st = tempST.st;
    }

    @Override
    public void delete(K key) {
        checkKey(key);
        checkEmpty();

        int i = hash(key);
        if(st[i].contains(key)){
            --n;
        }
        st[i].delete(key);

        //resize if average length of list is less
        if(m>INITIAL_CAPACITY && n <= MIN_AVERAGE_LENGTH_OF_LIST*m){
            resize(m>>1);
        }
    }

    @Override
    public Iterable<K> keys() {
        QueueList<K> queue = new QueueList<K>();
        for (int i = 0; i < m; i++) {
            Iterable<K> keys = st[i].keys();
            if(!((Collection<K>)keys).isEmpty()){
                for (K key : keys) {
                    queue.enQueue(key);
                }
            }
        }
        return queue;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public K select(Integer k) {
        return null;
    }

    @Override
    public Integer rank(K key) {
        return null;
    }

    @Override
    public Iterable<K> keys(K low, K high) {
        return null;
    }

    @Override
    public Integer size(K low, K high) {
        return null;
    }

    @Override
    public Integer height() {
        return null;
    }

    @Override
    public Iterable<K> levelOrder() {
        return null;
    }

    @Override
    public void printPaths() {

    }

    @Override
    public boolean isBST() {
        return false;
    }

    private void checkKey(K key) {
        if (key == null)
            throw new IllegalArgumentException("key is missing");
    }

    private void checkEmpty() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
    }
}
