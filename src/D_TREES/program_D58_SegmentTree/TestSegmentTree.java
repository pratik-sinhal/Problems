package D_TREES.program_D58_SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class TestSegmentTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SegmentTree tree = new SegmentTree();

        Character ans;
        Integer choice;

        int[] a = {-1,3,4,0,2,1};
        int[] ST = new int[20];
        Arrays.fill(ST, Integer.MAX_VALUE);

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. construct segment tree: ");
            System.out.println("2. query segment tre: ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    tree.constructTree(a, 0, a.length-1, ST, 0);
                    System.out.println("array representation of segment tree: \n"+Arrays.toString(ST));
                    break;

                case 2:
                    System.out.print("Enter query start index:");
                    int qStart = s.nextInt();
                    System.out.print("Enter query end index:");
                    int qEnd = s.nextInt();
                    System.out.println(tree.queryTree(0,a.length-1,ST,qStart,qEnd,0));
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
