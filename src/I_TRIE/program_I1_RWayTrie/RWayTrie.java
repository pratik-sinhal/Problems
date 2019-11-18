package I_TRIE.program_I1_RWayTrie;

/**
 * Created by pratik on 11/4/18.
 */
public class RWayTrie {

    private static final int ALPHABET_SIZE = 256;
    TrieNode root;

    public RWayTrie() {
        root = null;
    }

    public boolean contains(String key) {
        return get(key);
    }

    private static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[ALPHABET_SIZE];
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    public void put(String key) {
        root = put(root, key, 0);
    }

    private TrieNode put(TrieNode node, String key, int pos) {
        if(node == null) node = new TrieNode();
        if(pos == key.length()) {
            node.isEndOfWord = true;
            return node;
        }
        char c = key.charAt(pos);
        node.children[c] = put(node.children[c], key, pos+1);
        return node;
    }

    public boolean get(String key) {
        TrieNode node = get(root, key, 0);
        if(node != null) return node.isEndOfWord;
        return false;
    }

    private TrieNode get(TrieNode node, String key, int pos) {
        if(node == null || pos == key.length()) return node;
        char c = key.charAt(pos);
        return get(node.children[c], key, pos+1);

    }
}
