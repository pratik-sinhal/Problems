package program_F8_Stack;

/**
 * Created by pratik_s on 28/9/16.
 */
public class StackArray<T> implements IStack<T> {
    private Object[] a;
    private Integer top;

    public StackArray(Integer size) {
        this.top = -1;
        this.a = new Object[size];
    }

    @Override
    public void push(T item) {
        Integer length = a.length;
        if(top == (length-1)) {
            throw new StackOverflowError("Stack overflow");
        }
        a[++top] = item;
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new Error("Stack underflow");
        }
        T item = (T)a[top--];
        return item;
    }

    @Override
    public Boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Integer size() {
        return top + 1;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new Error("Stack underflow");
        }
        return (T)a[top];
    }
}
