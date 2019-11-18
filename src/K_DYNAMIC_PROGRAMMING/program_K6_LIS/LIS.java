package K_DYNAMIC_PROGRAMMING.program_K6_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pratik on 4/4/18.
 */
public class LIS {
    private int[] a;
    private Long[] cache;

    public LIS(int[] a) {
        this.a = a;
        this.cache = new Long[a.length];
    }

    public long LISTD(int n){

        // base cases
        if(n==0) return 1;

        long max = 1;

        for (int i = n-1; i >= 0; i--) {
            long lis = LISTD(i);
            if(a[n] > a[i]) {
                lis = lis + 1;
            }
            max = Math.max(max, lis);
        }

        return max;
    }

    public long LISBU() {
        int n = a.length;
        List<Integer> list = new ArrayList<Integer>();

        // base case
        for (int i = 0; i <n; i++) {
            cache[i] = 1l;
        }

        long maxLength = 1;
        int maxPos = -1;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j<i; j++) {
                if(a[i] > a[j] && cache[i]<cache[j]+1) {
                    cache[i] = cache[j] + 1;
                }
            }
            if(cache[i] > maxLength) {
                maxPos = i;
                maxLength = cache[i];
            }
        }

        //System.out.println(maxPos);

        //System.out.println(Arrays.toString(cache));

        printAllSequences(0,1, maxLength, maxPos, new ArrayList<Integer>());

        return maxLength;
    }

    private void printAllSequences(int start, int minLength, long maxLength, int maxPos, List<Integer> list) {
        if(minLength > maxLength) {
            System.out.println(list);
            return;
        }

        for (int i = start; i <= maxPos; i++) {
            if(cache[i] == minLength) {
                List<Integer> list1 = new ArrayList<Integer>(list);
                list1.add(a[i]);
                printAllSequences(i+1, minLength+1, maxLength, maxPos, list1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        LIS lis = new LIS(a);

        // top-down approach
        long length = lis.LISTD(a.length-1);
        System.out.println("Length of longest increasing sub-sequence = " + length);

        // bottom-up approach
        length = lis.LISBU();
        System.out.println("Length of longest increasing sub-sequence = " + length);

    }

    private static void printMatrix(int[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
