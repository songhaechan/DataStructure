package collection.set;

public class MyHashSetV1Main {
    public static void main(String[] args) {
        MyHashSetV1 set = new MyHashSetV1();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(7);
        set.add(8);
        set.add(14);
        set.add(9);
        set.add(99);

        System.out.println(set);
    }
}
