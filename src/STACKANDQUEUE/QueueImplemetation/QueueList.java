package STACKANDQUEUE.QueueImplemetation;

import LINKEDLIST.program_E2_LinkedList.LinkedListNode;

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by pratik_s on 28/9/16.
 */
public class QueueList<T> implements IQueue<T> {
    private Integer n;
    private LinkedListNode<T> front;
    private LinkedListNode<T> rear;

    public QueueList() {
        n = 0;
    }

    @Override
    public void enQueue(T item) {
        LinkedListNode<T> node = new LinkedListNode<T>(item);
        if(front == null) {
            front = rear = node;
            ++n;
            return;
        }
        rear.next = node;
        rear = node;
        ++n;
    }

    @Override
    public T deQueue() {
        if(isEmpty()){
            throw new Error("Queue underflow");
        }
        T data = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        --n;
        return data;
    }

    @Override
    public Boolean isEmpty() {
        return front == null;
    }

    @Override
    public Integer size() {
        return n;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new Error("Queue underflow");
        }
        return front.data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
