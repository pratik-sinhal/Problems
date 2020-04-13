package TripletSum;

import java.util.Scanner;

/**
 * Created by pratik_s on 25/9/16.
 */
public class TestTripletSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("No of elements in array");
        Integer n = s.nextInt();

        Integer[] a = new Integer[n];

        System.out.println("Enter elements of the array");
        for (int i = 0; i < n; i++)
            a[i] = s.nextInt();

        System.out.println("Enter triplet sum value");
        Integer sum = s.nextInt();

        TripletSum.tripletSum(a, sum);
    }
}
