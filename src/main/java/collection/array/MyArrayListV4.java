package collection.array;


import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size=0;

    public MyArrayListV4(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int initialCapacity){
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(E e){
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

    public E get(int index){
        //noinspection unchecked
        return (E) elementData[index];
    }

    public E set(int index, E element){
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(E o){
        for (int i = 0; i < size; i++) {
            if(o.equals(elementData[i])){
                return i;
            }
        }
        return -1;
    }

    public E add(int index, E o){
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

    public E remove(int index){
        E oldValue = (E) elementData[index];
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

