package me.lm.algorithm.queue.app;

import me.lm.algorithm.queue.PriorityQueue;
import me.lm.algorithm.queue.ArraySeqPQ;
import me.lm.algorithm.sort.app.Select;

/**
 * P MN time + M mem
 * D unorder + ordered
 *
 * @author bule_ann
 * @since 2021/12/17
 */
public class SelectByPQ implements Select {

    private PriorityQueue queue;

    @Override
    public Comparable[] topM(Comparable[] array, int M) {
        queue = new ArraySeqPQ(M + 1);
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
