package DYNAMICPROGRAMMING.program_K12_RodCutting;

public class RodCutting {
        private int[] length;
        private int[] price;
        private Integer[][] cache;
        private Integer[] table;
        private int[][] count;

        public RodCutting(int[] length, int[] price) {
            this.length = length;
            this.price = price;
            this.cache = new Integer[length.length+1][price.length+1];
            this.table = new Integer[length.length+1];
            this.count = new int[length.length+1][price.length+1];
        }

        public int rodCuttingTD(int length){
            // base cases
            if(length == 0 || length < 0) return 0;

            if(table[length] != null) return table[length];

            int result = 0;

            for (int i = 1; i <= length; i++) {
                int value = price[i-1] + rodCuttingTD(length-i);
                result = Math.max(result,value);
            }

            table[length] = result;

            return result;
        }

        public int rodCuttingBU(int n) {
            int[] cache = new int[n+1];
            cache[0] = 0;


            for (int i = 0; i < n; i++) {
                for (int j = length[i]; j <= n; j++) {
                    int value = price[i] + cache[j-length[i]];
                    cache[j] = Math.max(value,cache[j]);
                }
            }

            //printMatrix(cache, a.length+1, sum+1);

            return cache[n];
        }


        public static void main(String[] args) {
            int[] length = {1,2,3,4,5,6,7,8};
            int[] prices = {3,5,8,9,10,17,17,20};

            RodCutting rodCutting = new RodCutting(length, prices);

            // top down approach
            int value = rodCutting.rodCuttingTD(length.length);
            System.out.println("Maximum obtainable price of the rod = " + value);

            // bottom up approach
            value = rodCutting.rodCuttingBU(length.length);
            System.out.println("Maximum obtainable price of the rod = " + value);
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
