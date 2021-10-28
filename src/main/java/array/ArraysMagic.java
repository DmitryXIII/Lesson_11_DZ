package array;

import java.util.ArrayList;

public class ArraysMagic<T> {

    private T[] array;
    private ArrayList<T> arrayList;

    public ArraysMagic(T... elements) {
        this.array = elements;
    }

    public void changeElements(int element1, int element2) {
        T temp = this.array[element1];
        this.array[element1] = this.array[element2];
        this.array[element2] = temp;
    }

    public void arrayToArrayList(T[] array) {
        this.arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            this.arrayList.add(array[i]);
        }
    }

    public T[] getArray() {
        return array;
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void printArray() {
        System.out.println("array:");
        for (T s : this.array) {
            System.out.println(s);
        }
    }

    public void printArrayList() {
        System.out.println("ArrayList:");
        for (T s : this.arrayList) {
            System.out.println(s);
        }
    }
}
