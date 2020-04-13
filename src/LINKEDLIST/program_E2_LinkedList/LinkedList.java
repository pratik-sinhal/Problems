package LINKEDLIST.program_E2_LinkedList;

import java.util.Iterator;

/**
 * Created by pratik_s on 25/9/16.
 * Bridge design pattern - abstraction/handle class
 */
public class LinkedList<T> {
    ILinkedList<T> linkedList;

    // injects a particular implementation of a linked list
    public LinkedList(ILinkedList linkedList) {
        this.linkedList = linkedList;
    }

    public void insertFirst(T item) {
        linkedList.insertFirst(item);
    }

    public void insertLast(T item) {
        linkedList.insertLast(item);
    }

    public T deleteFirst() {
        return linkedList.deleteFirst();
    }

    public T deleteLast() {
        return linkedList.deleteLast();
    }

    public void traverse() {
        linkedList.traverse();
    }

    public LinkedListNode<T> getHead() {
        return linkedList.getHead();
    }

    public Iterator<T> iterator() {
        return linkedList.iterator();
    }
}
