package D_TREES.program_D35_RedBlackBST;

import java.util.Scanner;

/**
 * Created by pratik on 15/4/18.
 */
public class TestRedBlackBST {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RedBlackBST bst = new RedBlackBST<Integer>();

        Character ans;
        Integer choice;

        /*bst.put(7);
        bst.put(6);
        bst.put(5);
        bst.put(4);
        bst.put(3);
        bst.put(2);
        bst.put(1);*/

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. is empty: ");
            System.out.println("2. size: ");
            System.out.println("3. contains: ");
            System.out.println("4. get: ");
            System.out.println("5. put: ");
            System.out.println("6. delete: ");
            System.out.println("7. inorder: ");
            System.out.println("8. preorder: ");
            System.out.println("9. height: ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    //System.out.println(bst.isEmpty());
                    break;

                case 2:
                    //System.out.println("Size = " + bst.size());
                    break;

                case 3:
                    System.out.println("Enter the key: ");
                    System.out.println(bst.contains(s.nextInt()));
                    break;

                case 4:
                    System.out.println("Enter the key: ");
                    System.out.println(bst.get(s.nextInt()));
                    break;

                case 5:
                    System.out.println("Enter the key: ");
                    bst.put(s.nextInt());
                    break;

                case 6:
                    System.out.println("Enter the key to be deleted: ");
                    //bst.delete(s.nextInt());
                    break;

                case 7:
                    System.out.println("Inorder traversal is: ");
                    System.out.println(bst.inorder());
                    break;

                case 8:
                    System.out.println("Preorder traversal is: ");
                    System.out.println(bst.preorder());
                    break;

                case 9:
                    System.out.println("height = "+ bst.height());
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
