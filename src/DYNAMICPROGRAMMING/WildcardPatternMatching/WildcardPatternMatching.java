package DYNAMICPROGRAMMING.WildcardPatternMatching;

public class WildcardPatternMatching {
    public static void main(String[] args) {
        String str = "xyxzzxy";
        String pattern = "x***y";

        System.out.println(isMatchTD(str, str.length()-1, pattern, pattern.length()-1));
        System.out.println(isMatchBU(str, str.length()-1, pattern, pattern.length()-1));
    }

    private static boolean isMatchTD(String str, int n, String pattern, int m) {
        if(n == 0 && m == 0)
            return true;

        if(n == 0 || m == 0)
            return false;

        if((str.charAt(n) == pattern.charAt(m)) || pattern.charAt(m) == '?')
            return isMatchTD(str, n-1, pattern, m-1);

        if(pattern.charAt(m) == '*')
            return isMatchTD(str, n-1, pattern, m) || isMatchTD(str, n-1, pattern, m-1);

        return false;
    }

    private static boolean isMatchBU(String str, int n, String pattern, int m) {
        boolean[][] a = new boolean[n+1][m+1];


        // initialize matrix with base cases
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i==0 && j==0) {
                    a[i][j] = true;
                    continue;
                }
                if(i == 0 || j == 0) {
                    a[i][j] =false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if((str.charAt(i) == pattern.charAt(j)) || pattern.charAt(j) == '?')
                    a[i][j] = a[i-1][j-1];

                if(pattern.charAt(j) == '*')
                    a[i][j] = a[i-1][j] || a[i-1][j-1];
            }
        }

        return a[n][m];
    }
}

