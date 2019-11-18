package E_LINKEDLIST.program_E2_LinkedList;

/**
 * Created by pratik_s on 25/9/16.
 * Bridge design pattern - interface/body
 */
public interface ILinkedList<T> extends Iterable<T>{
    void insertFirst(T item);
    void insertLast(T item);
    T deleteFirst();
    T deleteLast();
    void traverse();
    LinkedListNode<T> getHead();
}
