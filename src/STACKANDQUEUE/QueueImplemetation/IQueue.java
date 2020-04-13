package STACKANDQUEUE.QueueImplemetation;

/**
 * Created by pratik_s on 28/9/16.
 */
public interface IQueue<T> extends Iterable<T>{
    void enQueue(T item);
    T deQueue();
    Boolean isEmpty();
    Integer size();
    T peek();
}
