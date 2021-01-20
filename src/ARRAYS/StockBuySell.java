package ARRAYS;

public class StockBuySell {
    public static void main(String[] args) {
        int[] a = {100, 180, 260, 310, 40, 535, 695};
        int[] b = {100, 50, 20, 10};
        int[] c = {10, 20, 50, 100};
        System.out.println(maxProfit(a));
        System.out.println(maxProfit(b));
        System.out.println(maxProfit(c));

    }

    private static int maxProfit(int[] a) {
        if(a.length <= 1)
            return 0;

        int n = a.length;
        int start = 0, i = 0, profit = 0;

        while(i < n-1) {

            while ((i < (n-1)) && (a[i] > a[i+1]))
                ++i;

            if(i == n-1)
                break;

            start = i;

            while ((i < (n-1)) && (a[i] < a[i+1]))
                ++i;

            profit += (a[i] - a[start]);
        }

        return profit;
    }
}
