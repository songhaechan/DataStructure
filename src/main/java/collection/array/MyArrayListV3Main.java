package collection.array;

public class MyArrayListV3Main {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();

        System.out.println("==데이터 추가==");
        System.out.println(list);
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add(4,"addList");
        System.out.println("list = " + list);
        // 성능이 제일 안좋다. 한 칸씩 다 밀어야함 O(N)
        list.add(0,"first");
        System.out.println("list = " + list);

        // 마찬가지로 성능이 좋지 않다. 제거하고 한 칸씩 밀어야함 O(N)
        System.out.println("list.remove(0) = " + list.remove(0));
        System.out.println("list = " + list);

    }
}
