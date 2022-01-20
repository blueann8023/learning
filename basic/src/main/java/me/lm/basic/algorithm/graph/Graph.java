package me.lm.basic.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/20
 */
public interface Graph {

    void addVertices(int v);

    void addEdge(int v, int s);

    Iterable<Integer> adjacent(int v);

    int countOfVertices();
//
//    int countOfEdge();
}
