package K_DYNAMIC_PROGRAMMING.MaximumSumRectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumRectangle {
    public static void main(String[] args) {
        int a[][] = new int[][] {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
        maxSumRectangle(a);
    }

    private static void maxSumRectangle(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;
        int[] rowSum = new int[rows];
        int maxRectSum = Integer.MIN_VALUE;
        int maxRectTop = 1;
        int maxRectLeft =1;
        int maxRectBottom = -1;
        int maxRectRight = -1;

        Arrays.fill(rowSum, 0);

        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {

                //update rowSum for every i,j
                updateRowSum(a, rowSum, j, rows, cols);

                //run 1-d kadane on rowSum
                int sum = 0;
                int maxSum = Integer.MIN_VALUE;
                int start = 0;
                int end = 0;
                for (int k = 0; k < rows; k++) {
                    sum += rowSum[k];
                    maxSum = Math.max(sum, rowSum[k]);
                    if(maxSum == sum){
                        end = j;
                    } else {
                        sum = rowSum[k];
                        start = i;
                        end = i;
                    }
                }
                // 1-d kadane end
                if(maxSum > maxRectSum) {
                    maxRectSum = maxSum;
                    maxRectTop = start;
                    maxRectLeft = i;
                    maxRectBottom = end;
                    maxRectRight = j;
                }
            }
            Arrays.fill(rowSum, 0);
        }
        System.out.println("Max rectangle sum = "+maxRectSum);
        System.out.println(maxRectTop + " " + maxRectLeft);
        System.out.println(maxRectBottom + " " + maxRectRight);
    }

    private static void updateRowSum(int[][] a, int[] rowSum, int j, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            rowSum[i] += a[i][j];
        }
    }
}
