package HASHING.SequentialSearchST;

import STACKANDQUEUE.QueueImplemetation.QueueList;
import TREE.BST.ISymbolTable;

import java.util.NoSuchElementException;

/**
 * Created by pratik_s on 18/12/16.
 */
public class SequentialSearchST<K,V> implements ISymbolTable<K,V> {

    private int n; // no. of key value pairs
    private SequentialSearchSTNode<K,V> first;

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Integer size() {
        return n;
    }

    @Override
    public Boolean contains(K key) {
        if(get(key) != null){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public V get(K key) {
        checkKey(key);
        checkEmpty();

        // if key already exists, return value
        for (SequentialSearchSTNode<K,V> ptr = first; ptr!=null; ptr=ptr.next) {
            if(key.equals(ptr.key)){
                return ptr.value;
            }
        }

        return null;
    }

    @Override
    public void put(K key, V value) {
        checkKey(key);
        // delete the key is value is null
        if(value == null){
            delete(key);
            return;
        }

        // if key already exists, replace old value with new
        for (SequentialSearchSTNode<K,V> ptr = first; ptr!=null; ptr=ptr.next) {
            if(ptr.key.equals(key)){
                ptr.value = value;
                return;
            }
        }

        // add new node to first
        first = new SequentialSearchSTNode<K, V>(key, value, first);
        return;
    }

    @Override
    public void delete(K key) {
        checkKey(key);
        checkEmpty();
        first = delete(first, key);
    }

    private SequentialSearchSTNode<K, V> delete(SequentialSearchSTNode<K, V> node, K key) {
        if(node == null){
            return null;
        }
        if(key.equals(node.key)){
            --n;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }

    @Override
    public Iterable<K> keys() {
        QueueList<K> queue = new QueueList<K>();
        for (SequentialSearchSTNode<K,V> ptr = first; ptr!=null; ptr=ptr.next) {
            queue.enQueue(ptr.key);
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
