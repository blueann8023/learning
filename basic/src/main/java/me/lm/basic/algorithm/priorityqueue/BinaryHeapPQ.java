package me.lm.basic.algorithm.priorityqueue;

/**
 * heap-ordered completed binary tree
 * D array index to  move
 * V
 * P ins-lgN del-lgN
 *
 * @author bule_ann
 * @since 2021/12/17
 */
public class BinaryHeapPQ implements PriorityQueue {

    private Comparable[] queue;
    private int size;

    public BinaryHeapPQ(int capacity) {
        this.queue = new Comparable[capacity + 1];
    }

    @Override
    public void insert(Comparable comparable) {
        queue[++size] = comparable;
        swim(size);
    }

    @Override
    public Comparable deleteMax() {
        Comparable max = queue[1];
        exch(1, size--);
        sink(1);
        queue[size + 1] = null;
        return max;
    }

    @Override
    public int size() {
        return size;
    }


    // 上浮
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    // 下潜
    private void sink(int k) {
        while (2 * k <= size) {
            int exchange = 2 * k;
            if (exchange < size && less(exchange, exchange + 1)) {
                exchange++;
            }
            exch(k, exchange);
            k = exchange;
        }
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
