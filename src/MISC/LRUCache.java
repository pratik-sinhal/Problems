package MISC;

import java.util.*;

public class LRUCache {
    private int size;
    private Set<Integer> cache;
    //private Map<Integer, Integer> map;

    public LRUCache(int size) {
        this.size = size;
        this.cache = new LinkedHashSet<>();
        //this.map = new HashMap<>();
    }

    /*private static class Node {
        int data;
        Node next;
    }*/

    public static void main(String[] args) {
        LRUCache lc = new LRUCache(4);
        lc.refer(1);
        lc.refer(2);
        lc.refer(3);
        lc.display();
        lc.refer(1);
        lc.display();
        lc.refer(4);
        lc.display();
        lc.refer(5);
        lc.display();
    }

    private void display() {
        cache.forEach(System.out::println);
        System.out.println("-----------");
    }

    private void refer(int i) {
        if(!cache.contains(i)){
            if(cache.size() == size) {
                Integer firstKey = cache.iterator().next();
                cache.remove(firstKey);
            }
            cache.add(i);
        } else {
            cache.remove(i);
            cache.add(i);
        }
    }
}
