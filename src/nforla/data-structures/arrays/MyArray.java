package arrays;

import java.util.Arrays;

/**
 * Simple implementation of a custom Array data structure.
 * */
public class MyArray {

    private Object[] data;
    private int length;
    private int capacity;

    public MyArray() {
        this.capacity = 1;
        this.length = 0;
        this.data = new Object[this.capacity];
    }

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.data = new Object[this.capacity];
    }

    public Object get(int index) {
        return this.data[index];
    }

    public void push(Object newElement) {
        if(capacity == length) {
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
        data[length] = newElement;
        length++;
    }

    public Object pop() {
        Object element = data[length - 1];
        data[length - 1] = null;
        length--;
        return element;
    }

    public void delete(int index) {
        shiftItems(index);
        length--;
    }

    private void shiftItems(int index) {
        for (int i = index; i < length - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    public static void main(String[] args) {
        MyArray m = new MyArray(5);
        m.push("Hello");
        m.push("World");
        m.push("!");
        m.push(1);
        m.pop();
        m.delete(1);
        for (int i = 0; i < m.length; i++) {
            System.out.println(m.get(i));
        }
    }
}
