package DYNAMICPROGRAMMING.program_K1_CoinChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pratik on 31/3/18.
 */
public class CoinChange {
    private int[] a;
    private int sum;
    private Long[][] cache;
    private int[][] count;

    public CoinChange(int[] a, int sum) {
        this.a = a;
        this.sum = sum;
        this.cache = new Long[a.length+1][sum+1];
        this.count = new int[a.length+1][sum+1];
    }

    public long numWaysCoinChangeTD(int n, int sum){
        //System.out.println(n+","+sum);

        // base cases
        if(sum==0) return 1;
        if(n==0 || sum<0) return 0;

        if(cache[n][sum] != null) return cache[n][sum];

        ++count[n][sum];

        cache[n][sum] = numWaysCoinChangeTD(n, sum-a[n-1]) + numWaysCoinChangeTD(n-1, sum);

        return cache[n][sum];
    }

    public long numWaysCoinChangeBU(int n, int sum) {
        for (int j = 1; j < sum + 1; j++) {
            cache[0][j] = 0l;
        }

        for (int i = 0; i < n + 1; i++) {
            cache[i][0] = 1l;
        }

        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j <sum+1; j++) {
                if(j-a[i-1] >= 0)
                    cache[i][j] = cache[i][j-a[i-1]] + cache[i-1][j];
                else
                    cache[i][j] = cache[i-1][j];
            }
        }

        // print all subsets if subset sum is true
        if(cache[n][sum] > 0) {
            printAllCoinCombinations(n, sum, new ArrayList<Integer>());
        }

        //printMatrix(cache, a.length+1, sum+1);

        return cache[n][sum];
    }

    public long numWaysCoinChangeBU2(int n, int sum) {
        long[] cache = new long[sum+1];

        Arrays.fill(cache,0l);

        //base case
        cache[0] = 1l;

        for (int i = 0; i < n; i++) {
            for (int j = a[i]; j <= sum; j++) {
                cache[j] = cache[j] + cache[j-a[i]];
            }
        }

        return cache[sum];
    }

    private void printAllCoinCombinations(int n, int sum, List<Integer> list) {
        if(sum == 0) {
            System.out.println(list);
            return;
        }

        if(n==0 || sum<0 || cache[n][sum] == 0) return;

        //do not include a[n-1]
        List<Integer> list2 = new ArrayList<>(list);
        printAllCoinCombinations(n-1, sum, list2);

        // include a[n-1]
        list.add(a[n-1]);
        printAllCoinCombinations(n, sum-a[n-1], list);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int sum=4;
        CoinChange coinChange = new CoinChange(a, sum);

        // top-down approach
        long startTS = System.currentTimeMillis();
        long ways = coinChange.numWaysCoinChangeTD(a.length, sum);
        long endTS = System.currentTimeMillis();
        System.out.println("Number of ways = " + ways);

        // bottom-up approach
        ways = coinChange.numWaysCoinChangeBU(a.length, sum);
        System.out.println("Number of ways = " + ways);

        // aliter --> bottom-up approach
        ways = coinChange.numWaysCoinChangeBU2(a.length, sum);
        System.out.println("Number of ways = " + ways);

    }

    private static void printMatrix(Long[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
