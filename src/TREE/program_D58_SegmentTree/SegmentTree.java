package TREE.program_D58_SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree {

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
            System.out.println("2. query segment tree: ");
            System.out.println("3. update segment tre: ");


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

                case 3:
                    System.out.print("Enter index to update:");
                    int index = s.nextInt();
                    System.out.print("Enter value to update:");
                    int val = s.nextInt();
                    tree.updateTree(a,0,a.length-1,ST,index,val,0);
                    System.out.println("array representation of segment tree: \n"+Arrays.toString(ST));
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }

    /**
     *
     * @param a is the input tree
     * @param start
     * @param end
     * @param ST is the Segment Tree
     * @param root is the root of the Segment Tree
     */
    public void constructTree(int[] a, int start, int end, int[] ST, int root){
        if(start == end) {
            ST[root] = a[start];
            return;
        }

        int mid = start + (end-start)/2;
        int left = 2*root+1;
        int right = 2*root+2;
        constructTree(a,start,mid,ST,left);
        constructTree(a,mid+1,end,ST,right);
        ST[root] = Math.min(ST[left],ST[right]);
    }

    /**
     *
     * @param start
     * @param end
     * @param ST
     * @param qStart
     * @param qEnd
     * @param root
     * @return
     */
    public int queryTree(int start, int end, int[] ST, int qStart, int qEnd, int root){
        // total overlap
        if(start >= qStart && end <= qEnd) return ST[root];

        //no overlap
        if((start < qStart && end < qStart) || (start > qEnd && end > qEnd)) return Integer.MAX_VALUE;

        //partial overlap
        int mid = start + (end-start)/2;
        int left = 2*root+1;
        int right = 2*root+2;

        return Math.min(queryTree(start,mid,ST,qStart,qEnd,left),
                queryTree(mid+1,end,ST,qStart,qEnd,right));
    }

    /**
     *
     * @param a
     * @param start
     * @param end
     * @param ST
     * @param index
     * @param val
     * @param root
     */
    private void updateTree(int[] a, int start, int end, int[] ST, int index, int val, int root) {
        if((start == end) && (start == index)) {
            ST[root] = val;
            return;
        }

        if(start >= end) {
            return;
        }

        int mid = start + (end-start)/2;
        int left = 2*root+1;
        int right = 2*root+2;
        updateTree(a, start, mid, ST, index, val, left);
        updateTree(a, mid+1, end, ST, index, val, right);
        ST[root] = Math.min(ST[left],ST[right]);
    }
}
