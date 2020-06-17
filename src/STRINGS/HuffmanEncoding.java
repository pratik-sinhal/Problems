package STRINGS;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

import java.util.*;

public class HuffmanEncoding {
    public static Scanner sc = new Scanner(System.in);
    public static final int NUM_CHARS = 256;

    private static class Node {
        Character ch;
        int freq;
        Node left;
        Node right;

        public Node(Character ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public Node(Character ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter string to be encoded");
        String s = sc.nextLine();
        //get frequency of all elements in input string
        int[] f = new int[NUM_CHARS];
        setFrequencies(s, f);
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        buildMinPriorityQueue(pq, f);
        buildEncodeTree(pq);
        Map<Character, String> codes = new HashMap<>();
        Node root = pq.peek();
        encode(root, codes, "");
        System.out.println("Huffman codes are: ");
        codes.forEach((k,v) -> System.out.println(k+": "+v));
        System.out.println("Original string is: "+s);
        StringBuilder sb = new StringBuilder(); // encoded string
        for (Character ch: s.toCharArray()) {
            sb.append(codes.get(ch));
        }
        System.out.println("Encoded string is: "+sb);
        System.out.print("Decoded string is: ");
        int i = 0;
        while (i < sb.length()) {
            i = decode(root, sb, i);
        }
    }

    private static int decode(Node root, StringBuilder sb, int index) {
        if(root == null)
            return index;

        if(root.ch != null) {
            System.out.print(root.ch);
            return index;
        }

        if(sb.charAt(index) == '0'){
            return decode(root.left, sb, index+1);
        } else {
            return decode(root.right, sb, index+1);
        }


    }

    private static void encode(Node root, Map<Character, String> codes, String s) {
        if(root == null) {
            return;
        }

        if(root.ch != null) {
            codes.put(root.ch, s);
            return;
        }

        encode(root.left, codes,s+'0');
        encode(root.right, codes,s+'1');
        return;
    }

    private static void buildEncodeTree(Queue<Node> pq) {
        while(pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            pq.add(new Node(null, a.freq + b.freq, a, b));
        }
    }

    private static void buildMinPriorityQueue(Queue<Node> pq, int[] f) {
        for (int i = 0; i < NUM_CHARS; i++) {
            if(f[i] > 0) {
                pq.add(new Node((char) i, f[i]));
            }
        }
    }

    private static void setFrequencies(String s, int[] f) {
        for (Character ch: s.toCharArray()) {
            f[ch]++;
        }
    }


}
