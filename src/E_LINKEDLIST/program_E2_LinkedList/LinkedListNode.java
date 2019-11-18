package E_LINKEDLIST.program_E2_LinkedList;

import lombok.Data;

/**
 * Created by pratik_s on 25/9/16.
 */
@Data
public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}
