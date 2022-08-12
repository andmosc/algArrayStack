package algStack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    private static final int INITIAL_CAPACITY = 10;

    private T[] data;
    private int numElements;


    public ArrayStack() {
        data = newArray(INITIAL_CAPACITY);
    }

    private T[] newArray(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[initialCapacity];
        return temp;
    }

    private void enlarge() {
        T[] temp = data;
        data = newArray(data.length * 2);
        System.arraycopy(temp, 0, data, 0,temp.length);
    }


    public void push(T element) {
        if (numElements == data.length) {
            enlarge();
        }

        data[numElements] = element;
        numElements++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[numElements - 1];
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = data[--numElements];
        data[numElements] = null;
        return element;
    }

    public boolean isEmpty() {
        return (numElements == 0);
    }

    public int capacity() {
        return data.length;
    }

    public int size() {
        return numElements;
    }

    public void clear() {
        data = newArray(INITIAL_CAPACITY);
        numElements = 0;
    }
}
