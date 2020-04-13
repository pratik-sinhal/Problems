package DYNAMICPROGRAMMING.program_K19_WordBreak;


import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public static void printAllWordBreaks(String str, List<String> dict, String out){
        if(str.length() == 0) {
            System.out.println(out);
        }

        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            if(dict.contains(prefix)){
                printAllWordBreaks(str.substring(i), dict, out+" "+prefix);
            }
        }
        return;
    }

    public static boolean wordBreakTD(String str, List<String> dict, String out){
        if(str.length() == 0) {
            System.out.println(out);
            return true;
        }

        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);
            if(dict.contains(prefix) && wordBreakTD(str.substring(i), dict, out+" "+prefix)) {
                return true;
            }
        }

        return false;
    }

    public static boolean wordBreakBU(String str, List<String> dict){
        // to do

        return false;
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous",
                "Word", "break", "b", "r", "e", "a", "k",
                "br", "bre", "brea", "ak", "problem");

        // input String
        String str = "Wordbreakproblem";

        //print all word breaks
        //printAllWordBreaks(str, dict, "");

        //check if word break exists Bottom Up
        boolean res = wordBreakTD(str, dict, "");
        System.out.println(res);

        res = wordBreakBU(str, dict);
        System.out.println(res);


    }

    private static void printMatrix(boolean[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
