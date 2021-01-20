package ARRAYS.TripletSum;

import java.util.Arrays;

/**
 * Created by pratik_s on 25/9/16.
 */
public class TripletSum {

    /**
     * Time complexity: O(n)
     * Auxiliary Space complexity: constant
     * @param a
     * @param sum
     */
    public static void tripletSum(Integer[] a, Integer sum) {
        Integer length = a.length;
        Arrays.sort(a);
        for (int i = 0; i < length - 2; i++) {
            Integer diff = sum - a[i];
            pairSum(a, i+1, diff);
        }
    }


    public static void pairSum(Integer[] a, int start, Integer sum) {
        Integer length = a.length;
        Integer i = start;
        Integer j = length - 1;
        while(i < j) {
            if((a[i] + a[j]) == sum) {
                System.out.println("Triplet: (" + a[start - 1] + ", " + a[i] + ", " + a[j] + ")");
                ++i;
                --j;
            }
            else if((a[i] + a[j]) < sum)
                ++i;
            else
                --j;
        }
    }
}
