package me.lm.algorithm.graph;

import java.util.Set;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/22
 */
public class AdjacentListEWDigraph implements EdgeWeightDigraph {

    private int v;
    private Bag<DirectedEdge>[] adjacent;

    @Override
    public void addEdge(DirectedEdge edge) {

    }

    @Override
    public Iterable<DirectedEdge> adjacent(int v) {
        return null;
    }

    @Override
    public Iterable<DirectedEdge> edges() {
        return null;
    }

    @Override
    public int V() {
        return 0;
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
