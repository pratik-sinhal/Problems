package D_TREES.program_D59_FenwickTree;

public class FenwickTree {

   public void constructTree(int[] a, int[] FT) {
       for (int i = 0; i < a.length; i++) {
           updateTree(FT, i+1, a[i]);
       }
   }

    private void updateTree(int[] FT, int i, int val) {
        while (i < FT.length){
            FT[i] += val;
            i = getNextIndex(i);
        }
    }

    private int getNextIndex(int i) {
        return i + (i & -i);
    }

    /**
     *
     * @param FT
     * @param qEnd end of sum query. Query is between 0 to qEnd
     */
    public int queryTree(int[] FT, int qEnd) {
        int i = qEnd+1;
        int sum = 0;
        while (i > 0) {
            sum += FT[i];
            i = getParent(i);
        }
        return sum;
    }

    private int getParent(int i){
        return i - (i & -i);
    }
}
