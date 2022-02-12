package me.lm.algorithm.graph;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/2/5
 */
public class DefaultDirectedEdge implements DirectedEdge{

    private int v,w;
    private float weight;

    public DefaultDirectedEdge(int v, int w, float weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public int from() {
        return 0;
    }

    @Override
    public int to() {
        return 0;
    }

    @Override
    public float weight() {
        return 0;
    }
}
