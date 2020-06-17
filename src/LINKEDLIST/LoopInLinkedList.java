package LINKEDLIST;

import LINKEDLIST.program_E2_LinkedList.ILinkedList;
import LINKEDLIST.program_E2_LinkedList.LinkedList;
import LINKEDLIST.program_E2_LinkedList.LinkedListNode;
import LINKEDLIST.program_E2_LinkedList.SinglyLinkedList;

import java.util.Scanner;

/**
 * Created by pratik_s on 17/12/16.
 */
public class LoopInLinkedList<T> {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ILinkedList<Integer> iLinkedList = new SinglyLinkedList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>(iLinkedList);

        LoopInLinkedList<Integer> loopInLL = new LoopInLinkedList<Integer>();

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
            System.out.println("1. Insert loop in list : ");
            System.out.println("2. Detect and remove loop(if any) : ");
            System.out.println("3. Traverse : ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    loopInLL.insertLoop(linkedList.getHead());
                    break;

                case 2:
                    System.out.println("Loop removed in list: "
                            + loopInLL.detectAndRemoveLoop(linkedList.getHead()));
                    break;

                case 3:
                    linkedList.traverse();
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }

    public void insertLoop(LinkedListNode<T> head){
        LinkedListNode<T> ptr = head;

        // insert a loop in list
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = head.next.next.next;
    }

    public Boolean detectAndRemoveLoop(LinkedListNode<T> head) {
        LinkedListNode<T> slow = head;
        LinkedListNode<T> fast = head;
        Boolean hasLoop = Boolean.FALSE;

        // detect if there is a loop
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                hasLoop = Boolean.TRUE;
                break;
            }
        }

        if(hasLoop){
            // find the starting node of the loop
            LinkedListNode<T> temp = fast;
            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }

            // remove loop
            while(temp.next != fast){
                temp = temp.next;
            }
            temp.next = null;
        }

        return hasLoop;
    }
}
