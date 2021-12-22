package me.lm.basic.algorithm.select;

import me.lm.basic.algorithm.priorityqueue.PriorityQueue;
import me.lm.basic.algorithm.priorityqueue.UnorderedArrayPQ;

/**
 * P MN time + M mem
 * D unorder + ordered
 *
 * @author bule_ann
 * @since 2021/12/17
 */
public class PQSelect implements Select {

    private PriorityQueue queue;

    @Override
    public Comparable[] topM(Comparable[] array, int M) {
        queue = new UnorderedArrayPQ(M + 1);
        for (int i = 0; i < array.length; i++) {
            queue.insert(array[i]);
            if (queue.size() > M) {
                queue.deleteMax();
            }
        }

        Comparable[] result = new Comparable[M];
        for (int i = 0; i < queue.size(); i++) {
            result[i] = queue.deleteMax();
        }
        return result;
    }
}
