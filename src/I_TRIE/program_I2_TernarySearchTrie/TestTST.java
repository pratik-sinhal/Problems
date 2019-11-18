package I_TRIE.program_I2_TernarySearchTrie;

import java.util.Scanner;

/**
 * Created by pratik on 13/4/18.
 */
public class TestTST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TernarySearchTrie trie = new TernarySearchTrie();

        Character ans;
        Integer choice;

        trie.put("the");
        trie.put("a");
        trie.put("their");
        trie.put("answer");
        trie.put("any");
        trie.put("by");
        trie.put("bye");
        trie.put("their");

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. is empty: ");
            System.out.println("2. size: ");
            System.out.println("3. contains: ");
            System.out.println("4. get: ");
            System.out.println("5. put: ");
            System.out.println("6. delete: ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    //System.out.println(trie.isEmpty());
                    break;

                case 2:
                    //System.out.println("Size = " + trie.size());
                    break;

                case 3:
                    System.out.println("Enter the key: ");
                    System.out.println(trie.contains(s.next()));
                    break;

                case 4:
                    System.out.println("Enter the key: ");
                    System.out.println(trie.get(s.next()));
                    break;

                case 5:
                    System.out.println("Enter the key: ");
                    trie.put(s.next());
                    break;

                case 6:
                    System.out.println("Enter the key to be deleted: ");
                    //trie.delete(s.nextInt());
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
