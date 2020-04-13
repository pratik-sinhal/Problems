package TREE.program_D59_FenwickTree;

import java.util.Arrays;
import java.util.Scanner;

public class TestFenwickTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FenwickTree tree = new FenwickTree();

        Character ans;
        Integer choice;

        int[] a = {-1,3,4,0,2,1};
        int[] FT = new int[a.length+1];
        Arrays.fill(FT, 0);

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. construct tree: ");
            System.out.println("2. query tree: ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    tree.constructTree(a,FT);
                    System.out.println("array representation of Fenwick tree: \n"+Arrays.toString(FT));
                    break;

                case 2:
                    System.out.print("Enter query end index:");
                    int qEnd = s.nextInt();
                    System.out.println(tree.queryTree(FT,qEnd));
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
