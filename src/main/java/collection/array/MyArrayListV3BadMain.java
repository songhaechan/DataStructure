package collection.array;

public class MyArrayListV3BadMain {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();

        list.add(1);
        list.add(2);
        list.add("문자3");
        System.out.println("list = " + list);
        Integer num1 = (Integer)list.get(0);
        Integer num2 = (Integer)list.get(1);

        //여기서 문제, 캐스팅 불가, 타입 불안정
        Integer num3 = (Integer)list.get(2);
    }
}
