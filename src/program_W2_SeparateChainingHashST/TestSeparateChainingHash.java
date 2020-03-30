package program_W2_SeparateChainingHashST;

import TREES.BST.ISymbolTable;
import TREES.BST.SymbolTable;

import java.util.Scanner;

/**
 * Created by pratik_s on 18/12/16.
 */
public class TestSeparateChainingHash {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ISymbolTable<Integer, String> iST = new SeparateChainingHashST<Integer, String>();
        SymbolTable<Integer, String> chainingHash = new SymbolTable<Integer, String>(iST);
        Character ans;
        Integer choice;

        chainingHash.put(8, "8");
        chainingHash.put(3, "3");
        chainingHash.put(1, "1");
        chainingHash.put(6, "6");
        chainingHash.put(4, "4");
        chainingHash.put(7, "7");
        chainingHash.put(10, "10");
        chainingHash.put(14, "14");
        chainingHash.put(13, "13");

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
            System.out.println("17. size: ");
            System.out.println("18. height: ");
            System.out.println("19. level order traversal: ");
            System.out.println("20. print paths");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println(chainingHash.isEmpty());
                    break;

                case 2:
                    System.out.println("Size = " + chainingHash.size());
                    break;

                case 3:
                    System.out.println("Enter the key: ");
                    System.out.println(chainingHash.contains(s.nextInt()));
                    break;

                case 4:
                    System.out.println("Enter the key: ");
                    System.out.println("value of the key is: " + chainingHash.get(s.nextInt()));
                    break;

                case 5:
                    System.out.println("Enter the value: ");
                    Integer value = s.nextInt();
                    chainingHash.put(value, Integer.toString(value));
                    break;

                case 6:
                    chainingHash.deleteMin();
                    break;

                case 7:
                    chainingHash.deleteMax();
                    break;

                case 8:
                    System.out.println("Enter the key to be deleted: ");
                    chainingHash.delete(s.nextInt());
                    break;

                case 9:
                    System.out.println("Min: " + chainingHash.min());
                    break;

                case 10:
                    System.out.println("Max: " + chainingHash.max());
                    break;

                case 11:
                    System.out.println("Enter the key: ");
                    System.out.println(chainingHash.floor(s.nextInt()));
                    break;

                case 12:
                    System.out.println("Enter the key: ");
                    System.out.println(chainingHash.ceiling(s.nextInt()));
                    break;

                case 13:
                    System.out.println("Enter the input: ");
                    System.out.println(chainingHash.select(s.nextInt()));
                    break;

                case 14:
                    System.out.println("Enter the key: ");
                    System.out.println(chainingHash.rank(s.nextInt()));
                    break;

                case 15:
                    System.out.print("Keys are: ");
                    for(Integer key: chainingHash.keys()) {
                        System.out.print(key + " ");
                    }
                    break;

                case 16:
                    System.out.println("Enter low value: ");
                    Integer low = s.nextInt();
                    System.out.println("Enter high value: ");
                    Integer high = s.nextInt();
                    System.out.print("Keys are: ");
                    for(Integer key: chainingHash.keys(low, high)) {
                        System.out.print(key + " ");
                    }
                    break;

                case 17:
                    System.out.println("Enter low value: ");
                    low = s.nextInt();
                    System.out.println("Enter high value: ");
                    high = s.nextInt();
                    System.out.println(chainingHash.size(low, high));
                    break;

                case 18:
                    System.out.println(chainingHash.height());
                    break;

                case 19:
                    System.out.print("Level order traversal is: ");
                    for(Integer key: chainingHash.levelOrder()) {
                        System.out.print(key + " ");
                    }
                    break;

                case 20:
                    chainingHash.printPaths();
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
