package collection.array;


import java.util.Arrays;

public class MyArrayListV3 {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size=0;

    public MyArrayListV3(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity){
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e){
        if(size == elementData.length){
            grow();
        }
        elementData[size] = e;
        size++;
    }

    private void grow(){
        int oldCapacity = elementData.length;
        int newCapacity = elementData.length*2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public Object get(int index){
        return elementData[index];
    }

    public Object set(int index, Object element){
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(Object o){
        for (int i = 0; i < size; i++) {
            if(o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    public Object add(int index, Object o){
        if(size == elementData.length){
            grow();
        }
        moveRightFrom(index);
        elementData[index] = o;
        size++;
        return o;
    }

    private void moveRightFrom(int index) {
        if (index <= size - 1) {
            for (int i = size - 1; i > index - 1; i--) {
                elementData[i + 1] = elementData[i];
            }
        }
    }

    public Object remove(int index){
        Object oldValue = elementData[index];
        moveLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue;
    }

    private void moveLeftFrom(int index){
        for (int i = index; i <size-1 ; i++) {
            elementData[i] = elementData[i+1];
        }
    }

    public String toString(){
        return Arrays.toString(Arrays.copyOf(elementData,size)) + " size="+size+ ", capacity="+elementData.length;
    }

}

