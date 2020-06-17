package DYNAMICPROGRAMMING.WildcardPatternMatching;

import java.util.Arrays;

public class WildcardPatternMatching {
    private static boolean isMatchTD(String str, int n, String pattern, int m) {
        if(n < 0 && m < 0)
            return true;

        if(m < 0)
            return false;

        else if(n < 0) {
            for (int i = 0; i < m; i++) {
                if(pattern.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if((str.charAt(n) == pattern.charAt(m)) || pattern.charAt(m) == '?')
            return isMatchTD(str, n-1, pattern, m-1);

        if(pattern.charAt(m) == '*')
            return isMatchTD(str, n-1, pattern, m) || isMatchTD(str, n, pattern, m-1);

        return false;
    }

    private static boolean isMatchBU(String str, int n, String pattern, int m) {
        if(m == 0)
            return (n==0);

        if(n == 0) {
            for (int i = 0; i < m; i++) {
                if(pattern.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        boolean[][] a = new boolean[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(a[i], false);
        }

        // initialize matrix with base cases
        a[0][0] = true;



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if((str.charAt(i-1) == pattern.charAt(j-1)) || pattern.charAt(j-1) == '?')
                    a[i][j] = a[i-1][j-1];

                if(pattern.charAt(j-1) == '*')
                    a[i][j] = a[i-1][j] || a[i][j-1];
            }
        }

        return a[n][m];
    }

    public static void main(String[] args) {
        String str = "";
        String pattern = "*";

        System.out.println(isMatchTD(str, str.length()-1, pattern, pattern.length()-1));
        System.out.println(isMatchBU(str, str.length(), pattern, pattern.length()));
    }
}

