package program_O1_Heap;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by pratik_s on 4/12/16.
 */
public class TestHeap {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer[] pq = new Integer[]{3,36,25,1,19,17,100,2,7};
        IPriorityQueue<Integer> iPQ = new Heap<Integer>(pq, new Heap.MaxHeapComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(iPQ);
        Character ans;
        Integer choice;

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. top: ");
            System.out.println("2. delete top: ");
            System.out.println("3. insert: ");
            System.out.println("4. print: ");
            System.out.println("5. heapify: ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println(heap.top());
                    break;

                case 2:
                    System.out.println(heap.deleteTop());
                    break;

                case 3:
                    System.out.println("Enter the key to insert: ");
                    heap.insert(s.nextInt());
                    break;

                case 4:
                    Iterator<Integer> iterator = heap.iterator();
                    while (iterator.hasNext()){
                        System.out.print(iterator.next() + " ");
                    }
                    break;

                case 5:

                    break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
