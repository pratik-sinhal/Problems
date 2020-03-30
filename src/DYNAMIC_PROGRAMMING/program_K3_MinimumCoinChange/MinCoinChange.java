package DYNAMIC_PROGRAMMING.program_K3_MinimumCoinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pratik on 31/3/18.
 */
public class MinCoinChange {
    private int[] a;
    private int sum;
    private Integer[][] cache;
    private Integer[] table;
    private int[][] count;

    public MinCoinChange(int[] a, int sum) {
        this.a = a;
        this.sum = sum;
        this.cache = new Integer[a.length+1][sum+1];
        this.table = new Integer[sum+1];
        this.count = new int[a.length+1][sum+1];
    }

    public int minCoinChangeTD(int sum){
        // base cases
        if(sum==0) return 0;
        if(sum<0) return Integer.MAX_VALUE;

        if(table[sum] != null) return table[sum];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int result = minCoinChangeTD(sum - a[i]);
            if(result != Integer.MAX_VALUE)
                min = Math.min(min,1+result);
        }

        table[sum] = min;

        return min;
    }

    public int minCoinChangeTD2(int n, int sum){
        //System.out.println(n+","+sum);

        // base cases
        if(sum==0) return 0;
        if(n==0 || sum<0) return Integer.MAX_VALUE;

        if(cache[n][sum] != null) return cache[n][sum];

        ++count[n][sum];

        int min = Math.min(Integer.MAX_VALUE, minCoinChangeTD2(n-1,sum));
        int result = minCoinChangeTD2(n,sum-a[n-1]);
        if(result != Integer.MAX_VALUE)
            min = Math.min(min, 1+result);

        cache[n][sum] = min;

        return min;
    }

    public int minCoinChangeBU(int n, int sum) {
        for (int j = 1; j < sum + 1; j++) {
            cache[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n + 1; i++) {
            cache[i][0] = 0;
        }

        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j <sum+1; j++) {
                if(j-a[i-1] >= 0) {
                    cache[i][j] = cache[i-1][j];
                    if(cache[i][j-a[i-1]] != Integer.MAX_VALUE)
                        cache[i][j] = Math.min(cache[i][j], 1+cache[i][j-a[i-1]]);
                } else {
                    cache[i][j] = cache[i - 1][j];
                }
            }
        }

        // print all subsets if subset sum is true
        if(cache[n][sum] != Integer.MAX_VALUE && cache[n][sum] != 0) {
            printCoins(n, sum, new ArrayList<Integer>());
        }

        //printMatrix(cache, a.length+1, sum+1);

        return cache[n][sum];
    }

    public int minCoinChangeBU2(int n, int sum) {
        int[] cache = new int[sum+1];
        Arrays.fill(cache,Integer.MAX_VALUE);
        cache[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = a[i]; j <= sum; j++) {
                int result = cache[j-a[i]];
                if(result != Integer.MAX_VALUE) {
                    result = result+1;
                }
                cache[j] = Math.min(result,cache[j]);
            }
        }

        return cache[sum];
    }

    private void printCoins(int n, int sum, List<Integer> list) {
        if(sum == 0) {
            System.out.println(list);
            return;
        }

        if(n==0 || cache[n][sum] == Integer.MAX_VALUE) return;

        int y = Integer.MAX_VALUE;

        int x = cache[n-1][sum];

        if(sum-a[n-1] >=0 && cache[n][sum-a[n-1]] != Integer.MAX_VALUE) {
            y = 1 + cache[n][sum - a[n - 1]];
        }

        if(x <= y) {
            printCoins(n-1, sum, list);
        }
        if(x >= y) {
            List<Integer> list1 = new ArrayList<Integer>(list);
            list1.add(a[n-1]);
            printCoins(n, sum-a[n-1], list1);
        }
    }

    public static void main(String[] args) {
        int[] a = {9,6,5,1};
        int sum = 11;
        MinCoinChange minCoinChange = new MinCoinChange(a, sum);

        // top down approach
        long startTS = System.currentTimeMillis();
        int sizeMinChangeSet = minCoinChange.minCoinChangeTD(sum);
        long endTS = System.currentTimeMillis();
        System.out.println("Size of the set with minimum no of coins = " + sizeMinChangeSet);

        // aliter - top down approach
        sizeMinChangeSet = minCoinChange.minCoinChangeTD2(a.length, sum);
        System.out.println("Size of the set with minimum no of coins = " + sizeMinChangeSet);

        // bottom up approach
        sizeMinChangeSet = minCoinChange.minCoinChangeBU(a.length, sum);
        System.out.println("Size of the set with minimum no of coins = " + sizeMinChangeSet);

        // aliter - bottom up approach
        sizeMinChangeSet = minCoinChange.minCoinChangeBU2(a.length, sum);
        System.out.println("Size of the set with minimum no of coins = " + sizeMinChangeSet);
    }

    private static void printMatrix(Integer[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }

        new ThreadLocal<Integer>();
    }
}
