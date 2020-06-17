package DYNAMICPROGRAMMING.AllUniquesBSTs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllUniqueBSTs {
    public static void main(String[] args) {
        int noOfNodes = 4;
        List<Node> rootList = printUniqueBSTs(1, noOfNodes);
        for (Node root: rootList) {
            preorder(root);
            System.out.println();
        }
    }

    private static void inorder(Node root) {
        if(root == null) return;

        Node ptr = root;
        Stack<Node> s = new Stack<>();

        while (!s.isEmpty() || ptr!=null) {
            while (ptr != null) {
                s.push(ptr);
                ptr = ptr.left;
            }

            ptr = s.pop();
            System.out.print(ptr.data + " ");
            ptr = ptr.right;
        }
    }

    private static void preorder(Node root) {
        if(root == null) return;

        Node ptr = root;
        Stack<Node> s = new Stack<>();

        s.push(ptr);

        while (!s.isEmpty()) {
            ptr = s.pop();
            System.out.print(ptr.data + " ");
            if(ptr.right != null)
                s.push(ptr.right);
            if(ptr.left != null)
                s.push(ptr.left);
        }
    }

    private static void postorder(Node root) {
    }

    private static List<Node> printUniqueBSTs(int start, int end) {

        List<Node> rootList = new ArrayList<>();

        if (start > end) {
            rootList.add(null);
            return rootList;
        }

        if (start == end) {
            rootList.add(new Node(start));
            return rootList;
        }

        for (int i = start; i <= end; i++) {
            List<Node> leftSubtreeNodes = printUniqueBSTs(start, i - 1);
            List<Node> rightSubtreeNodes = printUniqueBSTs(i + 1, end);

            for (Node left : leftSubtreeNodes) {
                for (Node right : rightSubtreeNodes) {
                    Node node = new Node(i);
                    node.left = left;
                    node.right = right;
                    rootList.add(node);
                }
            }
        }

        return rootList;
    }
}

@Data
@AllArgsConstructor
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}
