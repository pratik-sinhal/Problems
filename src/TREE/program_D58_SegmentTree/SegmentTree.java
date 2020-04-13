package TREE.program_D58_SegmentTree;

public class SegmentTree {

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
}
