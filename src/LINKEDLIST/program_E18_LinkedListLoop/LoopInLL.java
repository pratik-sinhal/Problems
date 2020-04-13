package LINKEDLIST.program_E18_LinkedListLoop;

import LINKEDLIST.program_E2_LinkedList.LinkedListNode;

/**
 * Created by pratik_s on 17/12/16.
 */
public class LoopInLL<T> {

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
