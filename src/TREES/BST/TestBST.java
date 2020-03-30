package TREES.BST;

import java.util.Scanner;

/**
 * Created by pratik_s on 25/9/16.
 */
public class TestBST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer[] i = {3,2,1,4,5};
        String[] j = {"3","2","1","4","5"};
        /*Integer[] i = {4,2,1,3,5};
        String[] j = {"4","2","1","3","5"};*/
        ISymbolTable<Integer, String> iST = new BST<Integer, String>(i,j);
        SymbolTable<Integer, String> bst = new SymbolTable<Integer, String>(iST);
        Character ans;
        Integer choice;

        /*ist.put(50, "50");
        ist.put(30, "30");
        ist.put(20, "20");
        ist.put(15, "15");
        ist.put(25, "25");
        ist.put(23, "23");
        ist.put(22, "22");1
        ist.put(24, "24");
        ist.put(26, "26");
        ist.put(55, "55");
        ist.put(52, "52");
        ist.put(60, "60");*/

        /*bst.put(8, "8");
        bst.put(3, "3");
        bst.put(1, "1");
        bst.put(6, "6");
        bst.put(4, "4");
        bst.put(7, "7");
        bst.put(10, "10");
        bst.put(14, "14");
        bst.put(13, "13");*/

        bst.put(10, "10");
        bst.put(7, "7");
        bst.put(7, "7");
        bst.put(10, "10");
        bst.put(14, "14");
        bst.put(13, "13");

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. is empty: ");
            System.out.println("2. size: ");
            System.out.println("3. contains: ");
            System.out.println("4. get: ");
            System.out.println("5. put: ");
            System.out.println("6. delete min: ");
            System.out.println("7. delete top: ");
            System.out.println("8. delete: ");
            System.out.println("9. min: ");
            System.out.println("10. top: ");
            System.out.println("11. floor: ");
            System.out.println("12. ceiling: ");
            System.out.println("13. select: ");
            System.out.println("14. rank: ");
            System.out.println("15. keys: ");
            System.out.println("16. keys in a range: ");
            System.out.println("17. size in a range: ");
            System.out.println("18. height: ");
            System.out.println("19. level order traversal: ");
            System.out.println("20. print paths");
            System.out.println("21. check is the tree is a BST");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println(bst.isEmpty());
                break;

                case 2:
                    System.out.println("Size = " + bst.size());
                    break;

                case 3:
                    System.out.println("Enter the key: ");
                    System.out.println(bst.contains(s.nextInt()));
                    break;

                case 4:
                    System.out.println("Enter the key: ");
                    System.out.println("value of the key is: " + bst.get(s.nextInt()));
                    break;

                case 5:
                    System.out.println("Enter the value: ");
                    Integer value = s.nextInt();
                    bst.put(value, Integer.toString(value));
                    break;

                case 6:
                    bst.deleteMin();
                    break;

                case 7:
                    bst.deleteMax();
                    break;

                case 8:
                    System.out.println("Enter the key to be deleted: ");
                    bst.delete(s.nextInt());
                    break;

                case 9:
                    System.out.println("Min: " + bst.min());
                    break;

                case 10:
                    System.out.println("Max: " + bst.max());
                    break;

                case 11:
                    System.out.println("Enter the key: ");
                    System.out.println(bst.floor(s.nextInt()));
                    break;

                case 12:
                    System.out.println("Enter the key: ");
                    System.out.println(bst.ceiling(s.nextInt()));
                    break;

                case 13:
                    System.out.println("Enter the input: ");
                    System.out.println(bst.select(s.nextInt()));
                    break;

                case 14:
                    System.out.println("Enter the key: ");
                    System.out.println(bst.rank(s.nextInt()));
                    break;

                case 15:
                    System.out.print("Keys are: ");
                    for(Integer key: bst.keys()) {
                        System.out.print(key + " ");
                    }
                    break;

                case 16:
                    System.out.println("Enter low value: ");
                    Integer low = s.nextInt();
                    System.out.println("Enter high value: ");
                    Integer high = s.nextInt();
                    System.out.print("Keys are: ");
                    for(Integer key: bst.keys(low, high)) {
                        System.out.print(key + " ");
                    }
                    break;

                case 17:
                    System.out.println("Enter low value: ");
                    low = s.nextInt();
                    System.out.println("Enter high value: ");
                    high = s.nextInt();
                    System.out.println(bst.size(low, high));
                    break;

                case 18:
                    System.out.println(bst.height());
                    break;

                case 19:
                    System.out.print("Level order traversal is: ");
                    for(Integer key: bst.levelOrder()) {
                        System.out.print(key + " ");
                    }
                    break;

                case 20:
                    bst.printPaths();
                    break;

                case 21:
                    System.out.println(bst.isBST());
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
