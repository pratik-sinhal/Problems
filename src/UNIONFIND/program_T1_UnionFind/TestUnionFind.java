package UNIONFIND.program_T1_UnionFind;

import java.util.Scanner;

/**
 * Created by pratik_s on 18/9/16.
 */
public class TestUnionFind {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("No of nodes");
        IUnionFind unionFind = new UnionFindImpl(s.nextInt());
        Character ans = ' ';
        do {
            Integer p = s.nextInt();
            Integer q = s.nextInt();
            System.out.println(p + " " + q);
            if(unionFind.connected(p,q))
                continue;
            unionFind.union(p,q);
            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);
        } while(ans != 'n');
        System.out.println(((UnionFindImpl)unionFind).getCount() + " components");
    }
}







