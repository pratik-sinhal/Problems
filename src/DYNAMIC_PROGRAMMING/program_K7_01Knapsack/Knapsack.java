package DYNAMIC_PROGRAMMING.program_K7_01Knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratik on 5/4/18.
 */
public class Knapsack {
    private int[] weights;
    private int[] profits;
    private int W;
    private Long[][] cache;
    private Boolean[] table;
    private int[][] count;

    public Knapsack(int[] weights, int[] profits, int W) {
        this.weights = weights;
        this.profits = profits;
        this.W = W;
        this.cache = new Long[weights.length+1][W+1];
        this.table = new Boolean[W+1];
        this.count = new int[weights.length+1][W+1];
    }

    public long knapSackTD(int n, int W){

        // base cases
        // third case since we don not want to include the profit for remaining wt. i.e. weights[n-1] > W
        if(W==0 || n==0 || weights[n-1] > W) return 0;

        return Math.max(knapSackTD(n-1, W), profits[n-1]+ knapSackTD(n-1, W-weights[n-1]));
    }

    public long knapSackBU() {
        int n = weights.length;

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < W+1; j++) {
                // base cases. could have been done in outside loops
                if(i==0 || j==0) {
                    cache[i][j] = 0l;
                    continue;
                }
                if(j-weights[i-1] >= 0)
                    cache[i][j] = Math.max(cache[i-1][j], profits[i-1] + cache[i-1][j-weights[i-1]]);
                else
                    cache[i][j] = cache[i-1][j];
            }
        }

        //printMatrix(cache, weights.length+1, W+1);

        printWeights(n, W, new ArrayList<Integer>());

        return cache[n][W];
    }

    private void printWeights(int n, int W, List<Integer> list) {
        if(W==0 || n==0 || weights[n-1] > W) {
            System.out.println(list);
            return;
        }

        long x = cache[n-1][W];
        long y = 0;

        if(W-weights[n-1] >= 0) {
            y = profits[n-1] + cache[n-1][W - weights[n - 1]];
        }

        if(x >= y) {
            printWeights(n-1, W, list);
        }
        if(y >= x) {
            List<Integer> list1 = new ArrayList<Integer>(list);
            list1.add(weights[n-1]);
            printWeights(n-1, W-weights[n-1], list1);
        }
    }

    public static void main(String[] args) {
        int[] weights = {24,10,10,7};
        int[] profits = {24,18,18,10};
        int W=25;
        Knapsack knapsack = new Knapsack(weights,profits,W);

        // top-down memoization approach
        long value = knapsack.knapSackTD(weights.length, W);
        System.out.println("Maximum knapsack value = "+value);

        // bottom up approach
        value = knapsack.knapSackBU();
        System.out.println("Maximum knapsack value = "+value);
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
