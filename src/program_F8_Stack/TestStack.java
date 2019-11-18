package program_F8_Stack;

import java.util.Scanner;

/**
 * Created by pratik_s on 28/9/16.
 */
public class TestStack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //System.out.println("Enter stack initial capacity");
        //TODO: implement factory or strategy pattern
        //IStack<Integer> iStack = new StackArray<Integer>(s.nextInt());
        IStack<Integer> iStack = new StackList<Integer>();
        Stack<Integer> stack = new Stack<Integer>(iStack);
        Character ans;
        Integer choice;

        stack.push(1);
        stack.push(4);
        stack.push(45);
        stack.push(6);
        stack.push(10);
        stack.push(8);

        do {
            System.out.println("---------------Menu-------------- ");
            System.out.println("1. Push : ");
            System.out.println("2. Pop : ");
            System.out.println("3. Peek : ");
            System.out.println("4. Size : ");

            System.out.println("Enter your choice: ");
            choice = s.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter value to push: ");
                    stack.push(s.nextInt());
                break;

                case 2:
                    System.out.println("popped item = " + stack.pop());
                break;

                case 3:
                    System.out.println("peeked(top) item = " + stack.peek());
                break;

                case 4:
                    System.out.println("size of the list is = " + stack.size());
                break;

                default:
                    System.out.println("Incorrect choice !!!");
            }

            System.out.println("Do you want to continue(y/n)?");
            ans = s.next().charAt(0);

        } while(ans != 'n');
    }
}
