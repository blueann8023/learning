package me.lm.algorithm.queue;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/3/29
 */
public class CircularQueue {

    private static final int cap = 100;

    private final Object[] queue;

    private int head = 0;

    private int size = 0;

    public CircularQueue() {
        this.queue = new Object[cap];
    }

    public void add(Object element) {
        if (size == cap) {
            throw new RuntimeException("full queue");
        }
        queue[head] = element;
        size++;
        head = head + 1 > cap ? 0 : head + 1;
    }

    public void remove() {
        if (size == 0) {
            throw new RuntimeException("empty queue");
        }
        queue[head + size] = null;
        size--;
    }

    public Object get() {
        if (size == 0) {
            throw new RuntimeException("empty queue");
        }
        return queue[head == 0 ? cap : head - 1];
    }
}
