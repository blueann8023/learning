package me.lm.algorithm.graph.ps;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/24
 */
public interface Order {

    Iterable<Integer> postOrder();

    Iterable<Integer> topologicalSort();
}
