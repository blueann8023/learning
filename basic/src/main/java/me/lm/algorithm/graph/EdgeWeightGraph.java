package me.lm.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public interface EdgeWeightGraph {
    void addEdge(Edge edge);

    Iterable<Edge> adjacent(int v);

    Iterable<Edge> edges();

    int V();

    int E();
}
