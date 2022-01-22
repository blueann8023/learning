package me.lm.basic.algorithm.graph;

import java.util.Set;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/20
 */
public class AdjacentListGraph implements Graph {

    private int countOfVertices;
    public Bag[] adjacent;

    @Override
    public void addVertices(int v) {

    }

    @Override
    public void addEdge(int v, int s) {

    }

    @Override
    public Iterable<Integer> adjacent(int v) {
        return null;
    }

    @Override
    public int countOfVertices() {
        return 0;
    }


    public static class Bag {
        private Set<Integer> vertices;
    }

}
