package DYNAMICPROGRAMMING.program_K2_OptimalGameStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik on 3/4/18.
 */
public class OptimalStrategy {
    private int[] coins;
    private Integer[][] cache;
    private int[][] count;

    public OptimalStrategy(int[] coins) {
        this.coins = coins;
        this.cache = new Integer[coins.length][coins.length];
        this.count = new int[coins.length][coins.length];
    }

    public int optimalStrategyTD(int start, int end) {
        //base case
        if(start == end)
            return coins[start];

        // if start and end span across two indices only, i.e. if there are only two pots of coins left
        if(end-start == 1)
            return Math.max(coins[start],coins[end]);

        // this base case is not required if the above one is there
//        if(start > end)
//            return 0;

        if (cache[start][end] != null)
            return cache[start][end];

        ++count[start][end];

        int a = coins[start] + Math.min(optimalStrategyTD(start+2,end), optimalStrategyTD(start+1, end-1));
        int b = coins[end] + Math.min(optimalStrategyTD(start+1,end-1), optimalStrategyTD(start, end-2));

        cache[start][end] = Math.max(a,b);

        return cache[start][end];
    }

    public int optimalStrategyBU() {
        int n = coins.length;

        // base case 1
        for (int i = 0; i < n; i++) {
            cache[i][i] = coins[i];
        }

        // base case 2
        for (int i = 0; i < n-1; i++) {
            cache[i][i+1] = Math.max(coins[i], coins[i+1]);
        }

        for (int i = 2; i < n; i++) {
            for (int start=0,end = i; end < n; start++,end++) {
                int a = coins[start] + Math.min(cache[start+2][end],cache[start+1][end-1]);
                int b = coins[end] + Math.min(cache[start+1][end-1],cache[start][end-2]);
                cache[start][end] = Math.max(a,b);
            }
        }

        //printMatrix(cache,n,n);

        printOptimalStrategy(0,n-1, cache[0][n-1], new ArrayList<Integer>());

        return cache[0][n-1];
    }

    private void printOptimalStrategy(int start, int end, int max, List<Integer> list) {
        //System.out.println(start+","+end+","+max);

        if(max == 0) {
            System.out.println(list);
            return;
        }

        if(start == end) {
            list.add(coins[start]);
            System.out.println(list);
            return;
        }

        int a = coins[start] + Math.min(cache[start+2][end],cache[start+1][end-1]);
        int b = coins[end] + Math.min(cache[start+1][end-1],cache[start][end-2]);

        int max1 = max;
        if(a == max) {
            list.add(coins[start]);
            max1 = max1 - coins[start++];
        }
        if(b == max) {
            list.add(coins[end]);
            max1 = max1 - coins[end--];
        }
        if(a != max && b != max) {
            ++start;
            --end;
        }

        printOptimalStrategy(start, end, max1, list);
    }

    public static void main(String[] args) {
        int[] coins = {6,1,4,9,8,5};
        OptimalStrategy strategy = new OptimalStrategy(coins);

        // top down approach
        int maxSum = strategy.optimalStrategyTD(0, coins.length-1);
        System.out.println("Maximum sum for player 1 = " + maxSum);

        // bottom up approach
        maxSum = strategy.optimalStrategyBU();
        System.out.println("Maximum sum for player 1 = " + maxSum);
    }

    private static void printMatrix(Integer[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
