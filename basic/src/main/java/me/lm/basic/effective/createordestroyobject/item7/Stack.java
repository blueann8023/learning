package me.lm.basic.effective.createordestroyobject.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by blue_ann on 04/09/2018.
 */
public class Stack {
    private final static int DEFAULT_INITIAL_CAPACITY = 16;

    private Object[] elements;

    private int size;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return elements[--size]; // bad
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }


}
