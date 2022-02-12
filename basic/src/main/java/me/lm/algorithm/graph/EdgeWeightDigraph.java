package me.lm.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public interface EdgeWeightDigraph {

    void addEdge(DirectedEdge edge);

    Iterable<DirectedEdge> adjacent(int v);

    Iterable<DirectedEdge> edges();

    int V();

    int E();
}
