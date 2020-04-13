package STACKANDQUEUE.StackImplemenation;

/**
 * Created by pratik_s on 28/9/16.
 */
public interface IStack<T> {
    void push(T item);
    T pop();
    Boolean isEmpty();
    Integer size();
    T peek();
}
