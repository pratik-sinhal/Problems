package STACKANDQUEUE.StackImplemenation;

/**
 * Created by pratik_s on 28/9/16.
 */
public class Stack<T> {
    IStack<T> stack;

    public Stack(IStack stack) {
        this.stack = stack;
    }

    public void push(T item) {
        stack.push(item);
    }

    public Integer size() {
        return stack.size();
    }

    public Boolean isEmpty() {
        return stack.isEmpty();
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }
}
