package STACKANDQUEUE.QueueImplemetation;

import java.util.Iterator;

/**
 * Created by pratik_s on 28/9/16.
 */
public class Queue<T>{
    private IQueue queue;

    public Queue(IQueue queue) {
        this.queue = queue;
    }

    public void enQueue(Object item) {
        queue.enQueue(item);
    }

    public Integer size() {
        return queue.size();
    }

    public Object peek() {
        return queue.peek();
    }

    public Boolean isEmpty() {
        return queue.isEmpty();
    }

    public Object deQueue() {
        return queue.deQueue();
    }

    public Iterator iterator() {
        return queue.iterator();
    }
}
