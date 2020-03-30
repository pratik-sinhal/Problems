package E_LINKEDLIST.program_E2_LinkedList;

import java.util.Iterator;

/**
 * Created by pratik_s on 25/9/16.
 * Bridge Design pattern - Concrete implementation
 */
public class SinglyLinkedList<T> implements ILinkedList<T>  {

    private LinkedListNode<T> head;

    @Override
    public void insertFirst(T item) {
        LinkedListNode<T> oldHead = head;
        head = new LinkedListNode<T>(item);
        head.setNext(oldHead);
    }

    @Override
    public void insertLast(T item) {
        if(head == null) {
            head = new LinkedListNode<T>(item);
            return;
        }
        LinkedListNode<T> node = head;
        while(node.getNext() != null){
            node = node.getNext();
        }
        node.setNext(new LinkedListNode<T>(item));
    }

    @Override
    public T deleteFirst() {
        if(head == null) {
            throw new NullPointerException("List is empty()");
        }
        T item = head.getData();
        head = head.getNext();
        return item;
    }

    @Override
    public T deleteLast() {
        if(head == null) {
            throw new NullPointerException("List is empty()");
        }
        if(head.getNext() == null){
            head.setNext(null);
        }
        LinkedListNode<T> front = head;
        LinkedListNode<T> back = head.getNext();
        while(back.getNext() != null){
            front = back;
            back = back.getNext();
        }
        front.setNext(null);
        return back.getData();
    }

    @Override
    public void traverse() {
        LinkedListNode<T> node = head;
        while(node != null){
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }

    @Override
    public Iterator<T> iterator() {
        return this.new Itr();
    }

    private class Itr implements Iterator<T> {
        private LinkedListNode<T> ptr;

        public Itr() {
            this.ptr = SinglyLinkedList.this.head;
        }

        @Override
        public boolean hasNext() {
            return ptr != null;
        }

        @Override
        public T next() {
            LinkedListNode<T> temp = ptr;
            ptr = ptr.next;
            return ptr.data;
        }

        @Override
        public void remove() {

        }
    }
}
