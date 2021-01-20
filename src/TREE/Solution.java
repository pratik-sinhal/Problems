package TREE;

import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    public boolean solution(String S, String T) {
        return sol(T,S);
    }

    public boolean sol(String str, String text) {
        if (str.length() > text.length())
            return false;

        int m = str.length(), n = text.length();

        //calculate lps array
        int[] lps = new int[m];
        computeLPS(lps, str, m);

        // search text in str
        int i=0, j=0;
        while(i < n){
            char c1 = text.charAt(i);
            char c2 = str.charAt(j);
            if(c1 == c2) {
                ++i;
                ++j;
                if(j == m) {
                    return true;
                }
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return false;
    }

    private void computeLPS(int[] lps, String pat, int m) {
        int i = 0, j = 1;
        lps[0] = 0;
        while (j < m) {
            char c1 = pat.charAt(i);
            char c2 = pat.charAt(j);
            if(c1 == c2) {
                lps[j] = i+1;
                ++i;
                ++j;
            } else { // if no match
                if(i == 0) {
                    lps[j] = 0;
                    ++j;
                } else {
                    i = lps[i-1];
                }
            }
        }
        //System.out.println(Arrays.toString(lps));
    }
}
