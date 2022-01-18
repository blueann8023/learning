package me.lm.basic.algorithm.sort.priorityqueue;

/**
 * 无序数组优先
 * P ins = 1,del = N
 * @author bule_ann
 * @since 2021/12/17
 */
public class UnorderedArrayPQ implements PriorityQueue {

    private Comparable[] queue;
    private int size;

    public UnorderedArrayPQ(int capacity) {
        queue = new Comparable[capacity];
    }

    @Override
    public void insert(Comparable comparable) {
        queue[size++] = comparable;
    }

    @Override
    public Comparable deleteMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (less(max, i)) {
                max = i;
            }
        }
        exch(max, size - 1);
        return queue[--size];
    }

    @Override
    public int size() {
        return size;
    }


    private boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    private void exch(int i, int j) {
        Comparable swap = queue[i];
        queue[i] = queue[j];
        queue[j] = swap;
    }
}
