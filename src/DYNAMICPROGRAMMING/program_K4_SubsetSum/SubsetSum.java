package DYNAMICPROGRAMMING.program_K4_SubsetSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik on 31/3/18.
 */
public class SubsetSum {
    private int[] a; // input array
    private int sum;
    private Boolean[][] cache;
    private int[][] count;

    public SubsetSum(int[] a, int sum) {
        this.a = a;
        this.sum = sum;
        this.cache = new Boolean[a.length+1][sum+1];
        this.count = new int[a.length+1][sum+1];
    }

    public boolean isSubsetSumTD(int n, int sum){
        //System.out.println(n+","+sum);

        // base cases
        if(sum==0) return true;
        if(n==0 || sum<0) return false;

        if(cache[n][sum] != null) return cache[n][sum];

        ++count[n][sum];

        cache[n][sum] = isSubsetSumTD(n-1, sum) || isSubsetSumTD(n-1, sum-a[n-1]);

        return cache[n][sum];
    }

    public boolean isSubsetSumBU(int n, int sum) {
        for (int j = 1; j <= sum; j++) {
            cache[0][j] = false;
        }

        for (int i = 0; i <= n; i++) {
            cache[i][0] = true;
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=sum; j++) {
                if(j-a[i-1] >= 0)
                    cache[i][j] = cache[i-1][j] || cache[i-1][j-a[i-1]];
                else
                    cache[i][j] = cache[i-1][j];
            }
        }

        // print all subsets if subset sum is true
        if(cache[n][sum]) {
            printSubsets(n, sum, new ArrayList<Integer>());
        }

        printMatrix(cache, a.length+1, sum+1);

        return cache[n][sum];
    }

    // initially i=n, sum=sum
    private void printSubsets(int i, int sum, List<Integer> list) {
        if(sum == 0) {
            System.out.println(list);
            return;
        }
        if(i==0 || sum<0 || !cache[i][sum]) return;

        // do not include a[i-1]th element
        List<Integer> list1 = new ArrayList<>(list);
        printSubsets(i-1, sum, list1);

        // include a[i-1]th element
        list.add(a[i-1]);
        printSubsets(i-1, sum-a[i-1], list);
    }

    public static void main(String[] args) {
        int[] a = {5,6,9,1,3,7};
        int sum=9;
        SubsetSum subsetSum = new SubsetSum(a,sum);

        // top-down memoization approach
        long startTS = System.currentTimeMillis();
        boolean isSubsetSum = subsetSum.isSubsetSumTD(a.length, sum);
        long endTS = System.currentTimeMillis();
        if(isSubsetSum) {
            System.out.println("Subset with sum "+sum+" exists");
        } else {
            System.out.println("Subset with sum "+sum+" does not exist");
        }

        // bottom up tabulation approach
        isSubsetSum = subsetSum.isSubsetSumBU(a.length, sum);
        if(isSubsetSum) {
            System.out.println("Subset with sum "+sum+" exists");
        } else {
            System.out.println("Subset with sum "+sum+" does not exist");
        }

//        System.out.println("startTS = "+startTS);
//        System.out.println("endTS = "+endTS);
//        System.out.println("time taken = "+(endTS-startTS));
        //printMatrix(subsetSum.count, a.length+1, sum+1);
    }

    private static void printMatrix(Boolean[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j] ? "1 " : "0 ");
            }
            System.out.print("\n");
        }
    }
}
