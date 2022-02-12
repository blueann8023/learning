package me.lm.algorithm.graph;

import java.util.Set;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/22
 */
public class AdjacentListEWGraph implements EdgeWeightGraph {

    private int v;
    private Bag<Edge>[] adjacent;

    @Override
    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adjacent[v].add(edge);
        adjacent[w].add(edge);
    }

    @Override
    public Iterable<Edge> adjacent(int v) {
        return adjacent[v].vertices;
    }

    @Override
    public Iterable<Edge> edges() {
        return null;
    }

    @Override
    public int V() {
        return v;
    }

    @Override
    public int E() {
        return 0;
    }


    public static class Bag<T> {
        Set<T> vertices;

        void add(T edge) {
            vertices.add(edge);
        }
    }
}
