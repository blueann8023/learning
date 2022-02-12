package me.lm.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public interface Edge {
    int either();

    int other(int v);

    int weight();
}
