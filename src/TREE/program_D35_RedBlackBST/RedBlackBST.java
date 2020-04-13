package TREE.program_D35_RedBlackBST;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by pratik on 15/4/18.
 */
public class RedBlackBST<T extends Comparable<T>> {
    private Node<T> root;

    public RedBlackBST() {
        root = null;
    }

    private enum Color {
        RED, BLACK
    }

    private static class Node<T> {
        T data;
        Color color;
        Node left;
        Node right;
        Node parent;

        public Node(T data, Color color, Node left, Node right, Node parent) {
            this.data = data;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(T data, Color color, Node parent) {
            this.data = data;
            this.color = color;
            this.parent = parent;
        }
    }

    public boolean contains(T key) {
        return get(key);
    }

    public void put(T key) {
        root = put(root, null, key);
    }

    private Node<T> put(Node<T> root, Node<T> parent, T key) {
        if(root == null){
            return new Node<T>(key, parent == null ? Color.BLACK : Color.RED, parent);
        }
        int cmp = key.compareTo(root.data);
        if(cmp < 0) {
            root.left = put(root.left, root, key);
        } else if(cmp > 0) {
            root.right = put(root.right, root, key);
        }
        return fixTree(root);
    }

    private Node<T> fixTree(Node<T> root) {
        if(isRed(root)) {
            // if node is root node
            if(root.parent == null) {
                root.color = Color.BLACK;
                return root;
            }
            if(isRed(root.left) || isRed(root.right)) {
                Node<T> uncle = getUncle(root);
                // flip colors case
                if(isRed(uncle)) {
                    flipColors(root.parent);
                    return root;
                }
            }
        } else {  // rotation case, if root is black
            Node<T> left = root.left;
            Node<T> right = root.right;
            if(isRed(left)) {
                Node<T> redChildLeft = getRedChild(left);
                if (redChildLeft != null) {
                    if (redChildLeft == left.left)
                        root = rotateLeft(root);
                    else if (redChildLeft == left.right) {
                        root.left = rotateRight(left);
                        root = rotateLeft(root);
                    }
                    root.color = Color.BLACK;
                    root.right.color = Color.RED;
                }
            } else if(isRed(right)){
                Node<T> redChildRight = getRedChild(right);
                if(redChildRight != null) {
                    if(redChildRight == right.right)
                        root = rotateRight(root);
                    else if(redChildRight == right.left) {
                        root.right = rotateLeft(right);
                        root = rotateRight(root);
                    }
                    root.color = Color.BLACK;
                    root.left.color = Color.RED;
                }
            }
        }
        return root;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> t = node.left;
        node.left = t.right;
        t.right = node;
        return t;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> t = node.right;
        node.right = t.left;
        t.left = node;
        return t;
    }

    private Node<T> getRedChild(Node<T> node) {
        if(node != null) {
            if(isRed(node.left))
                return node.left;
            if(isRed(node.right))
                return node.right;
        }
        return null;
    }

    private void flipColors(Node<T> node) {
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node<T> getUncle(Node<T> root) {
        if(root.parent != null) {
            if(root.parent.left == root)
                return root.parent.right;
            else
                return root.parent.left;
        }
        return null;
    }

    private boolean isRed(Node<T> node) {
        return node != null && node.color == Color.RED;
    }

    public boolean get(T key) {
        return get(root, key) != null;
    }

    private Node<T> get(Node<T> root, T key) {
        if(root == null)
            return null;
        int cmp = key.compareTo(root.data);
        if(cmp == 0)
            return root;
        else if(cmp < 0)
            return get(root.left, key);
        else
            return get(root.right, key);
    }

    public Iterable<T> inorder() {
        Node<T> current = root;
        Stack<Node<T>> s = new Stack<Node<T>>();
        ArrayList<T> list = new ArrayList<T>();
        while (current != null || !s.isEmpty()){
            if(current != null) {
                s.push(current);
                current = current.left;
            } else {
                Node<T> node = s.pop();
                list.add(node.data);
                current = node.right;
            }
        }
        return list;
    }

    public Iterable<T> preorder() {
        Stack<Node<T>> s = new Stack<Node<T>>();
        ArrayList<T> list = new ArrayList<T>();

        if(root == null) return list;
        s.push(root);
        while (!s.isEmpty()){
            Node<T> node = s.pop();
            list.add(node.data);
            if(node.right != null) s.push(node.right);
            if(node.left != null) s.push(node.left);
        }
        return list;
    }

    public Integer height() {
        return height(root);
    }

    private Integer height(Node<T> root) {
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
