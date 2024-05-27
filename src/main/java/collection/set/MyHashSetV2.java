package collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class MyHashSetV2 {
    private static int DEFAULT_INITIAL_CAPACITY = 16;
    LinkedList<Object>[] buckets;
    private int capacity = DEFAULT_INITIAL_CAPACITY;
    private int size;

    public MyHashSetV2() {
        init();
    }

    public MyHashSetV2(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(Object value) {
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            return false;
        }
        bucket.add(value);
        size++;
        return true;

    }

    public boolean contains(Object value) {
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        return bucket.contains(hashIndex);
    }

    public int getSize(){
        return size;
    }

    public boolean remove(Object value) {
        int hashIndex = hashIndex(value);
        LinkedList<Object> bucket = buckets[hashIndex];
        boolean contains = bucket.remove(value);
        if(contains){
            size--;
            return true;
        }else{
            return false;
        }
    }

    public int hashIndex(Object value) {
        return Math.abs(value.hashCode())% capacity;
    }

    @Override
    public String toString() {
        return "MyHashSetV2{" +
                "buckets=" + Arrays.toString(buckets) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
