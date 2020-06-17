package NUMBERS;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfAStream {

    private java.util.Queue<Integer> minPQ;
    private Queue<Integer> maxPQ;

    public MedianOfAStream() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public static void main(String[] args) {
        MedianOfAStream m = new MedianOfAStream();
        int[] a = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        for (int x: a) {
            m.addToStream(x);
            System.out.println(m.getMedian());
        }
    }

    public void addToStream(int x) {
        if(maxPQ.isEmpty()) {
            maxPQ.add(x);
        } else if(x < maxPQ.peek()) {
            maxPQ.add(x);
        } else {
            minPQ.add(x);
        }
        balance();
    }

    private void balance() {
        if(maxPQ.size() - minPQ.size() > 1){
            minPQ.add(maxPQ.poll());
        } else if(minPQ.size() - maxPQ.size() > 1) {
            maxPQ.add(minPQ.poll());
        }
    }

    public int getMedian() {
        /*if(maxPQ.isEmpty() && minPQ.isEmpty()) {
            throw new Exception("No element in stream!!");
        }*/
        if(maxPQ.size() > minPQ.size()){
            return maxPQ.peek();
        } else if(minPQ.size() > maxPQ.size()) {
            return minPQ.peek();
        } else {
            return (maxPQ.peek()+minPQ.peek())>>1;
        }
    }
}
