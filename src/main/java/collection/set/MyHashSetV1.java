package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV1 {
    private static int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Integer>[] buckets;
    private int capacity = DEFAULT_INITIAL_CAPACITY;
    private int size;

    public MyHashSetV1() {
        init();
    }

    public MyHashSetV1(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }
        bucket.add(value);
        size++;
        return true;

    }

    public boolean contains(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(hashIndex);
    }

    public int getSize(){
        return size;
    }

    public boolean remove(int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        boolean contains = bucket.remove(Integer.valueOf(value));
        if(contains){
            size--;
            return true;
        }else{
            return false;
        }
    }

    public int hashIndex(int value) {
        return value % capacity;
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "buckets=" + Arrays.toString(buckets) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
