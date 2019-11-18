package K_DYNAMIC_PROGRAMMING.program_K11_EggDroppingPuzzle;

public class EggDropping {
    private int k; // no of floors
    private int n; // no of eggs
    private Integer[][] cache;

    public EggDropping(int k, int n) {
        this.k = k;
        this.n = n;
        this.cache = new Integer[n+1][k+1];
    }

    public int eggDroppingTD(int n, int k){

        if (k==1 || k==0)
            return k;

        if(n==1)
            return k;

        int minDrops = Integer.MAX_VALUE;

        if(cache[n][k] != null)
            return cache[n][k];

        for (int i = 1; i <= k; i++) {
            int maxOfBothStrategies = 1 + Math.max(eggDroppingTD(n,k-i),eggDroppingTD(n-1,i-1));
            if(maxOfBothStrategies < minDrops){
                minDrops = maxOfBothStrategies;
            }
        }

        cache[n][k] = minDrops;

        return minDrops;
    }

    public long eggDroppingBU() {
        for (int i = 0; i <= n; i++) {
            cache[i][0] = 0;
            cache[i][1] = 1;
        }

        for (int j = 0; j <= k; j++) {
            cache[1][j] = j;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                int minDrops = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    int maxOfBothStrategies = 1 + Math.max(cache[i][j-l], cache[i-1][l-1]);
                    if (maxOfBothStrategies < minDrops) {
                        minDrops = maxOfBothStrategies;
                    }
                }
                cache[i][j] = minDrops;
            }
        }

        //printMatrix(cache,k,n);

        return cache[n][k];
    }

    public static void main(String[] args) {
        int k = 10;
        int n = 2;
        EggDropping eggDropping = new EggDropping(k,n);

        // top-down memoization approach
        long value = eggDropping.eggDroppingTD(n,k);
        System.out.println("Minimum no of egg drops = "+value);

        // bottom up approach
        value = eggDropping.eggDroppingBU();
        System.out.println("Minimum no of egg drops = "+value);
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
