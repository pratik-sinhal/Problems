package K_DYNAMIC_PROGRAMMING.program_K14_EditDistance;

public class EditDistance {
    private String s1;
    private String s2;
    private Integer[][] cache;
    private int count = 0;

    public EditDistance(String s1, String s2) {
        this.cache = new Integer[s1.length()+1][s2.length()+1];
        this.s1 = s1;
        this.s2 = s2;
    }

    public int editDistanceTD(int n1, int n2){
        //System.out.println(n1+","+n2);
        ++count;

        // base cases

        if(n1 == 0) return n2;
        if(n2 == 0) return n1;

        if(cache[n1][n2] != null) return cache[n1][n2];

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return editDistanceTD(n1-1, n2-1);
        }

        cache[n1][n2] = 1+min(editDistanceTD(n1,n2-1), editDistanceTD(n1-1,n2), editDistanceTD(n1-1, n2-1));

        return cache[n1][n2];
    }

    private int min(int a, int b, int c) {
        return a<b ? (a<c ? a : (b<c ? b : c)) : (b<c ? b : c);
    }

    public int editDistanceBU() {
        int n1 = s1.length();
        int n2 = s2.length();

        for (int j = 0; j <= n2; j++) {
            cache[0][j] = j;
        }

        for (int i = 0; i <= n1; i++) {
            cache[i][0] = i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    cache[i][j] = cache[i-1][j-1];
                } else {
                    cache[i][j] = 1 + min(cache[i][j-1], cache[i-1][j], cache[i-1][j-1]);
                }
            }
        }

        //printMatrix(cache, a.length+1, sum+1);

        return cache[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        EditDistance editDistance = new EditDistance(s1, s2);

        // top-down approach
        int noOfEdits = editDistance.editDistanceTD(s1.length(), s2.length());
        System.out.println("Minimum no of edits = " + noOfEdits);
        System.out.println("count = "+editDistance.count);

        // bottom-up approach
        noOfEdits = editDistance.editDistanceBU();
        System.out.println("Minimum number of edits = " + noOfEdits);
    }

    private static void printMatrix(Long[][] a, int row, int col) {
        for (int i = 0; i <row; i++) {
            for (int j = 0; j <col; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
}
