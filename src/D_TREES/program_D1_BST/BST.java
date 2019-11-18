package D_TREES.program_D1_BST;

import java.util.*;

/**
 * Created by pratik_s on 25/9/16.
 * Bridge design pattern - Concrete Implementation
 */
public class BST<K extends Comparable<K>, V> implements ISymbolTable<K,V> {

    private STNode<K,V> root;
    private STNode<K,V> prev; // only for isBST() check

    /**
     * Done
     * @param i
     * @param j
     */
    public BST(K[] i, V[] j){
        root = new STNode<K,V>(i[0],j[0],1);
        root.left = new STNode<K,V>(i[1],j[1],1);
        root.left.left = new STNode<K,V>(i[2],j[2],1);
        root.left.right = new STNode<K,V>(i[3],j[3],1);
        root.right = new STNode<K,V>(i[4],j[4],1);
    }

    @Override
    /**
     * Done
     * O(n)
     */
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    /**
     * Done
     * O(n)
     */
    public Integer size() {
        return size(root);
    }

    private Integer size(STNode<K, V> root) {
        if(root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public Boolean contains(K key) {
        checkKey(key);
        return get(key) != null;
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public V get(K key) {
        checkKey(key);
        checkEmpty();
        STNode<K, V> node = get(root, key);
        return node != null ? node.value : null;
    }

    private STNode<K, V> get(STNode<K, V> root, K key) {
        if(root == null)
            return null;
        int cmp = key.compareTo(root.key);
        if(cmp == 0)
            return root;
        else if(cmp < 0)
            return get(root.left, key);
        else
            return get(root.right, key);
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public void put(K key, V value) {
        checkKey(key);
        if(value == null) {
            delete(key);
            return;
        }
        // can be done with finding the parent approach also
        root = put(root, key, value);
    }

    private STNode<K, V> put(STNode<K,V> root, K key, V value) {
        if(root == null){
            return new STNode<K, V>(key, value, 1);
        }
        int cmp = key.compareTo(root.key);
        if(cmp < 0) {
            root.left = put(root.left, key, value);
        } else if(cmp > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.value = value;
        }
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public void deleteMin() {
        checkEmpty();
        root = deleteMin(root);
    }

    private STNode<K, V> deleteMin(STNode<K, V> root) {
        if(root.left == null){
            return root.right; // Important line
        }
        root.left = deleteMin(root.left);
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public void deleteMax() {
        checkEmpty();
        root = deleteMax(root);
    }

    private STNode<K, V> deleteMax(STNode<K, V> root) {
        if(root.right == null){
            return root.left; // Important line
        }
        root.right = deleteMax(root.right);
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    @Override
    public void delete(K key) {
        checkKey(key);
        root = delete(root, key);
    }

    private STNode<K, V> delete(STNode<K, V> root, K key) {
        if (root == null) return null;

        int cmp = key.compareTo(root.key);
        if      (cmp < 0) root.left  = delete(root.left,  key);
        else if (cmp > 0) root.right = delete(root.right, key);
        else {
            if (root.right == null) return root.left;
            if (root.left  == null) return root.right;
            STNode<K, V> temp = root;
            root = min(temp.right);
            root.right = deleteMin(temp.right);
            root.left = temp.left;
        }
        root.size = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public K min() {
        checkEmpty();
        return min(root).key;
    }

    private STNode<K,V> min(STNode<K, V> root) {
        if(root.left == null){
            return root;
        }
        return min(root.left);
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public K max() {
        checkEmpty();
        return max(root).key;
    }

    private STNode<K,V> max(STNode<K, V> root) {
        if(root.right == null){
            return root;
        }
        return max(root.right);
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public K floor(K key) {
        checkKey(key);
        checkEmpty();
        return floor(root, key).key;
    }

    private STNode<K, V> floor(STNode<K, V> root, K key) {
        if(root == null)
            return null;
        int cmp = key.compareTo(root.key);
        if(cmp == 0)
            return root;
        if(cmp < 0)
            return floor(root.left, key);
        else {
            STNode t = floor(root.right, key);
            if(t == null)
                return root;
            else
                return t;
        }
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public K ceiling(K key) {
        checkKey(key);
        checkEmpty();
        return ceiling(root, key).key;
    }

    private STNode<K, V> ceiling(STNode<K, V> root, K key) {
        if(root == null)
            return null;
        int cmp = key.compareTo(root.key);
        if(cmp == 0)
            return root;
        if(cmp > 0)
            return ceiling(root.right, key);
        else {
            STNode t = ceiling(root.left, key);
            if(t == null)
                return root;
            else
                return t;
        }
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public K select(Integer k) {
        if(k < 0 || k >= size())
            throw new IllegalArgumentException(k + " is not within range");
        checkEmpty();
        return select(root, k).key;
    }

    private STNode<K, V> select(STNode<K, V> root, Integer k) {
        if(root == null)
            return null;
        Integer t = size(root.left);
        if(t == k)
            return root;
        else if(t > k)
            return select(root.left, k);
        else
            return select(root.right, k-t-1);
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public Integer rank(K key) {
        checkKey(key);
        checkEmpty();
        return rank(root, key);
    }

    private Integer rank(STNode<K, V> root, K key) {
        /*if(root == null)
            return 0;
        int cmp = key.compareTo(root.key);
        if(cmp == 0)
            return size(root.left);
        else if(cmp < 0)
            return rank(root.left, key);
        else return 1 + size(root.left) + rank(root.right, key);*/

        //ALITER: without using size function utility
        if(root == null)
            return 0;
//        if(root.left == null && key != root.key)
//            return 1;
        int cmp = key.compareTo(root.key);
        if(cmp <= 0)
            return rank(root.left, key);
        else return 1 + rank(root.left, key) + rank(root.right, key);
    }

    @Override
    /**
     * Done
     * O(n)
     */
    public Iterable<K> keys() {
        return keys(min(), max());
    }

    @Override
    /**
     * Done
     * O(n)
     */
    public Iterable<K> keys(K low, K high) {
        checkKey(low);
        checkKey(high);
        Queue<K> queue = new LinkedList<K>();
        keys(root, queue, low, high);
        return queue;
    }

    private void keys(STNode<K, V> root, Queue<K> queue, K low, K high) {
        if(root == null){
            return;
        }
        int cmplow = low.compareTo(root.key);
        int cmphigh = high.compareTo(root.key);
        if(cmplow < 0){
            keys(root.left, queue, low, high);
        }
        if(cmplow <= 0 && cmphigh >= 0){
            queue.add(root.key);
        }
        if(cmphigh > 0) {
            keys(root.right, queue, low, high);
        }
        return;
    }

    @Override
    /**
     * Done
     * O(n)
     */
    public Integer size(K low, K high) {
        checkKey(low);
        checkKey(high);
        checkEmpty();
        if(low.compareTo(high) > 0)
            return 0;
        /*if(contains(high))
            return rank(high) - rank(low) + 1;
        return rank(high) - rank(low);*/

        //ALITER: without using rank function utility
        return size(root, low, high);
    }

    private Integer size(STNode<K, V> root, K low, K high) {
        if(root == null)
            return 0;
        int c1 = 0, c2 = 0;
        int cmplow = low.compareTo(root.key);
        int cmphigh = high.compareTo(root.key);
        if(cmplow < 0)
            c1 = size(root.left, low, high);
        if(cmphigh > 0)
            c2 = size(root.right, low, high);
        if(cmplow <= 0 && cmphigh >= 0)
            return c1 + c2 + 1;
        return c1 + c2;
    }

    @Override
    /**
     * Done
     * O(lg n)
     */
    public Integer height() {
        checkEmpty();
        return height(root);
    }

    private Integer height(STNode<K, V> root) {
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    @Override
    /**
     * Done
     * O(n)
     */
    public Iterable<K> levelOrder() {
        checkEmpty();
        Queue<STNode<K, V>> queue = new LinkedList<STNode<K, V>>();
        Queue<K> keys = new LinkedList<K>();
        queue.add(root);
        while(!queue.isEmpty()){
            STNode<K, V> node = queue.remove();
            if(node != null) {
                keys.add(node.key);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return keys;
    }

    @Override
    public void printPaths() {
        checkEmpty();
        List<STNode<K,V>> queue = new ArrayList<STNode<K, V>>();
        printPaths(root, queue, 0);
    }

    @Override
    public boolean isBST() {
        //return isBST(root, null, null);

        //ALITER:
        return isBST(root);
    }

    private boolean isBST(STNode<K, V> x, K min, K max) {
        if (x == null)
            return true;
        if (min != null && x.key.compareTo(min) <= 0) {
            return false;
        }
        if (max != null && x.key.compareTo(max) >= 0) {
            return false;
        }
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    private boolean isBST(STNode<K, V> root) {
        if(root == null)
            return true;
        Boolean x = isBST(root.left);
        if(!x) return x;
        if(prev != null && root.key.compareTo(prev.key) <= 0){
            return false;
            //x = false;
        }
        prev = root;
        return x && isBST(root.right);
    }

    private void printPaths(STNode<K, V> root, List<STNode<K, V>> queue, Integer pathLength) {
        if(root == null) {
            return;
        }
        queue.add(pathLength, root);
        ++pathLength;
        if(root.left == null && root.right == null){
            print(queue, pathLength);
        }
        printPaths(root.left, queue, pathLength);
        printPaths(root.right, queue, pathLength);
        return;
    }

    private void print(List<STNode<K, V>> queue, Integer pathLength) {
        System.out.println();
        for (int i=0; i<pathLength; i++) {
            System.out.print(queue.get(i).key + " ");
        }
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
