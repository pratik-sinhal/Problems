package I_TRIE.program_I2_TernarySearchTrie;

/**
 * Created by pratik on 13/4/18.
 */
public class TernarySearchTrie {

    private Node root;

    public TernarySearchTrie() {
        root = null;
    }

    private static class Node {
        char c;
        Node left;
        Node mid;
        Node right;

        public Node(char c) {
            this.c = c;
            left = null;
            mid = null;
            right = null;
        }
    }

    public boolean contains(String key) {
        return get(key);
    }

    public void put(String key) {
        root = put(root, key, 0);
    }

    private Node put(Node node, String key, int pos) {
        char c = key.charAt(pos);
        if(node == null) node = new Node(c);
        if(c < node.c)
            node.left = put(node.left, key, pos);
        else if(c > node.c)
            node.right = put(node.right, key, pos);
        else if(pos+1 < key.length())
            node.mid = put(node.mid, key, pos+1);
        return node;
    }

    public boolean get(String key) {
        Node node = get(root, key, 0);
        if(node != null) return true;
        return false;
    }

    private Node get(Node node, String key, int pos) {
        if(node == null) {
            return node;
        }
        char c = key.charAt(pos);
        if(c < node.c)
            return get(node.left, key, pos);
        else if(c > node.c)
            return get(node.right, key, pos);
        else if(pos+1 < key.length())
            return get(node.mid, key, pos+1);
        return node;
    }
}
