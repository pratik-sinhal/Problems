package STRINGS;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "ABDCBCDBDCBBC";
        System.out.println(LPSTD(s, 0, s.length()-1));
        System.out.println(LPSBU(s));
        System.out.println(NonDP(s));
    }

    /**
     * DP top down
     * @param s
     * @param start
     * @param end
     * @return
     */
    private static int LPSTD(String s, int start, int end) {
        if(start == end)
            return 1;

        boolean b = s.charAt(start) == s.charAt(end);
        if(end == start+1 && b)
            return 2;

        int res = 1;

        if(b) {
            //second condition is for checking continuity
            if (LPSTD(s, start + 1, end - 1) == (end - start - 1))
                res = Math.max(res, end - start + 1);
        }
        res = Math.max(res, Math.max(LPSTD(s,start+1,end), LPSTD(s,start,end-1)));

        return res;
    }

    /**
     * DP bottom up
     * @param s
     * @return
     */
    private static int LPSBU(String s) {
        int len = s.length();
        boolean[][] a = new boolean[len][len];
        int maxLength = 1,start=0,end=0;

        for (boolean[] row: a)
            Arrays.fill(row, false);

        for (int i = 0; i < len; i++)
            a[i][i] = true;

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                a[i][i + 1] = true;
                maxLength = 2;
                start = i;
                end = i+1;
            }
        }

        for (int k = 0; k < len - 2; k++) {
            for (int i=0,j=k+2; j < len; i++,j++) {
                if (s.charAt(i) == s.charAt(j) && a[i+1][j-1]){
                    a[i][j] = true;
                    if(j-i+1 > maxLength){
                        maxLength = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        System.out.println("string = "+s.substring(start,end+1));
        return maxLength;
    }

    /**
     * Non DP solution
     * @param s
     * @return
     */
    private static int NonDP(String s) {
        int len = s.length(),currLen=0,maxLength=0,start=0,end=0;
        for (int i = 0; i < len; i++) {

            //for every odd length substring
            currLen = expand(s,i,i);
            if(currLen > maxLength)
                maxLength = currLen;

            //for every even length substring
            currLen = expand(s,i,i+1);
            if(currLen > maxLength) {
                maxLength = currLen;
            }
        }
        return maxLength;
    }

    private static int expand(String s, int start, int end) {
        int len = s.length();
        while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)){
            --start;
            ++end;
        }
        return end-start-1;
    }
}
