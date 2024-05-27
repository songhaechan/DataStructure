package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }

        System.out.println("buckets = " + Arrays.toString(buckets));

        add(buckets,1);
        add(buckets,2);
        add(buckets,5);
        add(buckets,7);
        add(buckets,9);
        add(buckets,14);
        add(buckets,99);

        System.out.println("buckets = " + Arrays.toString(buckets));

        System.out.println("contains(buckets,99) = " + contains(buckets, 99));
        System.out.println("contains(buckets,3) = " + contains(buckets, 3));

    }

    private static void add(LinkedList<Integer>[] buckets, int value){
        int haseIndex = haseIndex(value);
        LinkedList<Integer> bucket = buckets[haseIndex]; // O(1)
        if(!bucket.contains(value)){ // O(n)
            bucket.add(value);
        }
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int value){
        int haseIndex = haseIndex(value);
        LinkedList<Integer> bucket = buckets[haseIndex]; // O(1)
        return bucket.contains(value); // O(n)
    }

    private static int haseIndex(int value){
        return value%CAPACITY;
    }
}
