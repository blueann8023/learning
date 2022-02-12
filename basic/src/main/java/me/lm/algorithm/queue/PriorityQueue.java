package me.lm.algorithm.queue;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2021/12/17
 */
public interface PriorityQueue {

    void insert(Comparable comparable);

    Comparable deleteMax();

    int size();
}
