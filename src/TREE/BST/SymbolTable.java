package TREE.BST;

/**
 * Created by pratik_s on 25/9/16.
 * Bridge design pattern - Abstraction. Refined Abstractions can follow
 */
public class SymbolTable<K extends Comparable<K>, V> {
    protected ISymbolTable<K,V> ist;

    // injects a particular implementation of a ist
    public SymbolTable(ISymbolTable ist) {
        this.ist = ist;
    }

    public Boolean isEmpty() {
        return ist.isEmpty();
    }

    public Integer size() {
        return ist.size();
    }

    public Boolean contains(K key) {
        return ist.contains(key);
    }

    public V get(K key) {
        return ist.get(key);
    }

    public void put(K key, V value) {
        ist.put(key, value);
    }

    public void deleteMin() {
        ist.deleteMin();
    }

    public void deleteMax() {
        ist.deleteMax();
    }

    public void delete(K key) {
        ist.delete(key);
    }

    public K min() {
        return ist.min();
    }

    public K max() {
        return ist.max();
    }

    public K floor(K key) {
        return ist.floor(key);
    }

    public K ceiling(K key) {
        return ist.ceiling(key);
    }

    public K select(Integer k) {
        return ist.select(k);
    }

    public Integer rank(K key) {
        return ist.rank(key);
    }

    public Iterable<K> keys() {
        return ist.keys();
    }

    public Iterable<K> keys(K low, K high) {
        return ist.keys(low, high);
    }

    public Integer size(K low, K high) {
        return ist.size(low, high);
    }

    public Integer height() {
        return ist.height();
    }

    public Iterable<K> levelOrder() {
        return ist.levelOrder();
    }

    public void printPaths() {
        ist.printPaths();
    }

    public boolean isBST() {
        return ist.isBST();
    }
}
