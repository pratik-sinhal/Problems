package DYNAMICPROGRAMMING;

public class LongestCommonSubstring {

    public static int longestCommonSubstrTD(String s1, String s2, int n1, int n2, int count){
        if(n1 == 0 || n2 == 0) return count;

        int res = 0;

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            res = longestCommonSubstrTD(s1, s2, n1-1, n2-1, 1+count);
        } else {
            res = count;
        }

        return Math.max(res,
                Math.max(longestCommonSubstrTD(s1, s2, n1-1, n2, 0), longestCommonSubstrTD(s1, s2, n1,n2-1,0)));
    }

    public static void main(String[] args) {
        String s1 = "ABXCDEFYZZ";
        String s2 = "ABYCDEFXZZ";

        // top-down approach
        System.out.println(longestCommonSubstrTD(s1, s2, s1.length(), s2.length(), 0));
    }
}
