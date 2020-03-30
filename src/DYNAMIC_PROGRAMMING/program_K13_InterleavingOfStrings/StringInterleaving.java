package DYNAMIC_PROGRAMMING.program_K13_InterleavingOfStrings;

public class StringInterleaving {
    private String s1;
    private String s2;
    private String s3;
    private boolean[][] cache;

    public StringInterleaving(String s1, String s2, String s3) {
        this.cache = new boolean[s1.length()+1][s2.length()+1];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public boolean stringInterleaving(int n1, int n2, int n3){

        // base cases
        if(n1 == 0 && n2 == 0 && n3 == 0) return true;

        if(n3 == 0) return false;

        if(n1 == 0) {
            return s3.charAt(n3-1) == s2.charAt(n2-1) && stringInterleaving(n1, n2 - 1, n3-1);
        }

        if(n2 == 0) {
            return s3.charAt(n3-1) == s1.charAt(n1-1) && stringInterleaving(n1-1, n2, n3-1);
        }

        if(s3.charAt(n3-1) == s1.charAt(n1-1) && s3.charAt(n3-1) != s2.charAt(n2-1)){
            return stringInterleaving(n1-1, n2, n3-1);
        }

        if(s3.charAt(n3-1) == s2.charAt(n2-1) && s3.charAt(n3-1) != s1.charAt(n1-1)){
            return stringInterleaving(n1, n2-1, n3-1);
        }

        if(s3.charAt(n3-1) == s1.charAt(n1-1) && s3.charAt(n3-1) == s2.charAt(n2-1)){
            return stringInterleaving(n1-1, n2, n3-1) || stringInterleaving(n1, n2-1, n3-1);
        }

        return false;
    }

    public boolean stringInterleavingBU() {
        int n1 = s1.length();
        int n2 = s2.length();

        for (int i = 0; i <=n1; i++) {
            for (int j = 0; j <=n2; j++) {
                cache[i][j] = false;
            }
        }

        for (int i = 0; i <=n1; i++) {
            for (int j = 0; j <=n2; j++) {

                if(i==0 && j==0)
                    cache[0][0] = true;
                else if(i == 0)
                    cache[i][j] = s3.charAt(j-1) == s2.charAt(j-1) && cache[i][j-1];
                else if(j == 0)
                    cache[i][j] = s3.charAt(i-1) == s1.charAt(i-1) && cache[i-1][j];
                else if(s3.charAt(i+j-1) == s1.charAt(i-1) && s3.charAt(i+j-1) != s2.charAt(j-1))
                    cache[i][j] = cache[i-1][j];
                else if(s3.charAt(i+j-1) == s2.charAt(j-1) && s3.charAt(i+j-1) != s1.charAt(i-1))
                    cache[i][j] = cache[i][j-1];
                else if(s3.charAt(i+j-1) == s1.charAt(i-1) && s3.charAt(i+j-1) == s2.charAt(j-1))
                    cache[i][j] = cache[i-1][j] || cache[i][j-1];
            }
        }

        return cache[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "XXY";
        String s2 = "XXZ";
        String s3 = "XXYXXZ";
        StringInterleaving stringInterleaving = new StringInterleaving(s1, s2, s3);

        // top-down approach
        boolean isInterleaved = stringInterleaving.stringInterleaving(s1.length(), s2.length(), s3.length());
        System.out.println(isInterleaved);

        // bottom-up approach
        isInterleaved = stringInterleaving.stringInterleavingBU();
        System.out.println(isInterleaved);
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
