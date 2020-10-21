package exercises.array_list;

import java.util.Arrays;

public class MyArrayList<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyArrayList() {
        ;
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity " + capacity);
        }

    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapacity(1);
        }
        elements[size] = element;
        size++;
        return true;
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else {
            if (size == elements.length) {
                ensureCapacity(1);
            }
            for (int i = index; i < size; i++) {
                elements[i + 1] = elements[i];
            }
            elements[index] = element;
            size++;
        }
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return size;
            }
        }
        return -1;
    }

    public boolean contains(E o) {
        if (this.indexOf(o) == -1) {
            return false;
        } else return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index: " + index);
        } else {
            E element = (E) elements[index];
            return element;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index: " + index);
        } else {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("Min capacity: " + minCapacity);
        }
    }

    public MyArrayList<E> clone(){
        MyArrayList<E> newList = new MyArrayList<>();
        newList.elements = Arrays.copyOf(this.elements, this.size);
        newList.size = this.size;
        return newList;
    }
}
