package E_LINKEDLIST.program_E2_LinkedList;

import java.util.Scanner;

/**
 * Created by pratik_s on 25/9/16.
 */
public class TestLinkedList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ILinkedList<Integer> iLinkedList = new SinglyLinkedList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>(iLinkedList);
        Character ans;
        Integer choice;

        linkedList.insertFirst(1);
        linkedList.insertLast(4);
        linkedList.insertLast(45);
        linkedList.insertLast(6);
        linkedList.insertLast(10);
        linkedList.insertLast(8);

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. InsertFirst : ");
            System.out.println("2. InsertLast : ");
            System.out.println("3. DeleteFirst : ");
            System.out.println("4. DeleteLast : ");
            System.out.println("5. Traverse : ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter value to insert: ");
                    linkedList.insertFirst(s.nextInt());
                break;

                case 2:
                    System.out.println("Enter value to insert: ");
                    linkedList.insertLast(s.nextInt());
                break;

                case 3:
                    linkedList.deleteFirst();
                break;

                case 4:
                    linkedList.deleteLast();
                break;

                case 5:
                    linkedList.traverse();
                break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
