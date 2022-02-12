package me.lm.algorithm.graph.ps;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/22
 */
public interface Cycle {
    boolean haseCycle();

    Iterable<Integer> cycle();

    Iterable<Integer> topologicalSort();
}
