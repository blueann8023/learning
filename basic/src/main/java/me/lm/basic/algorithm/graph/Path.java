package me.lm.basic.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/20
 */
public interface Path {

    boolean hasPath(int from, int to);

    Iterable<Integer> path(int from, int to);
}
