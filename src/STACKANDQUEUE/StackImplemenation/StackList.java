package STACKANDQUEUE.StackImplemenation;

import LINKEDLIST.program_E2_LinkedList.LinkedListNode;

/**
 * Created by pratik_s on 28/9/16.
 */
public class StackList<T> implements IStack<T> {
    private LinkedListNode<T> top;
    private Integer n; // holds size of the stack

    public StackList() {
        this.n = 0;
    }

    @Override
    public void push(T item) {
        LinkedListNode oldTop = top;
        top = new LinkedListNode<T>(item);
        top.setNext(oldTop);
        ++n;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new Error("Stack underflow");
        }
        T item = top.getData();
        top = top.getNext();
        --n;
        return item;
    }

    @Override
    public Boolean isEmpty() {
        return top == null;
    }

    @Override
    public Integer size() {
        return n;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new Error("Stack underflow");
        }
        return top.getData();
    }
}
