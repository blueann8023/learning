package me.lm.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public class DefaultEdge implements Edge, Comparable<DefaultEdge> {
    private int v;
    private int w;
    private int weight;

    @Override
    public int either() {
        return 0;
    }

    @Override
    public int other(int v) {
        return 0;
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public int compareTo(DefaultEdge o) {
        return Integer.compare(this.weight, o.weight());
    }
}
