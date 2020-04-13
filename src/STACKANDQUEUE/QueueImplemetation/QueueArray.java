package STACKANDQUEUE.QueueImplemetation;

import java.util.Iterator;

/**
 * Created by pratik_s on 28/9/16.
 */
public class QueueArray<T> implements IQueue<T> {
    private Object[] a;
    private Integer front;
    private Integer rear;

    public QueueArray(Integer initialCapacity) {
        a = new Object[initialCapacity];
        front = -1;
        rear = -1;
    }

    @Override
    public void enQueue(T item) {
        if(rear == (a.length-1)) {
            throw new Error("Queue overflow");
        }
        if(isEmpty()) {
            front = rear = 0;
            a[front] = item;
            return;
        }
        a[++rear] = item;
    }

    @Override
    public T deQueue() {
        T item;
        if(isEmpty()) {
            throw new Error("Queue underflow");
        }
        if(front == rear) {
            item = (T)a[front];
            front = rear = -1;
            return item;
        }
        item = (T)a[front++];
        return item;
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Integer size() {
        return front == -1 ? 0 : (rear - front + 1);
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new Error("Queue underflow");
        }
        return (T)a[front];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
