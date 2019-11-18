package program_G2_Queue;

import java.util.Scanner;

/**
 * Created by pratik_s on 28/9/16.
 */
public class TestQueue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //System.out.println("Enter initial capacity");
        //TODO: implement factory or strategy pattern
        //IQueue<Integer> iQueue = new QueueArray<Integer>(s.nextInt());
        IQueue<Integer> iQueue = new QueueList<Integer>();
        Queue<Integer> queue = new Queue<Integer>(iQueue);
        Character ans;
        Integer choice;

        queue.enQueue(1);
        queue.enQueue(4);
        queue.enQueue(45);
        queue.enQueue(6);
        queue.enQueue(10);
        queue.enQueue(8);

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. Enqueue : ");
            System.out.println("2. Dequeue : ");
            System.out.println("3. Peek : ");
            System.out.println("4. Size : ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter value to enqueue: ");
                    queue.enQueue(s.nextInt());
                    break;

                case 2:
                    System.out.println("dequeued item = " + queue.deQueue());
                    break;

                case 3:
                    System.out.println("peeked(top) item = " + queue.peek());
                    break;

                case 4:
                    System.out.println("size of the list is = " + queue.size());
                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
