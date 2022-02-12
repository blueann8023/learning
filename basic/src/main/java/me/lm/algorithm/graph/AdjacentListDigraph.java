package me.lm.algorithm.graph;

import java.util.Set;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/22
 */
public class AdjacentListDigraph implements Digraph {

    private int countOfVertices;
    private Bag[] adjacent;

    @Override
    public void addVertices(int v) {
        adjacent[v] = new Bag();
    }

    @Override
    public void addEdge(int from, int to) {
        adjacent[from].vertices.add(to);
    }

    @Override
    public Iterable<Integer> adjacent(int v) {
        return adjacent[v].vertices;
    }

    @Override
    public int countOfVertices() {
        return countOfVertices;
    }

    @Override
    public Digraph reverse() {
        return null;
    }

    public static class Bag {
        Set<Integer> vertices;
    }
}
