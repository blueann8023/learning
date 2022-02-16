package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.DefaultDirectedEdge;
import me.lm.algorithm.graph.DirectedEdge;
import me.lm.algorithm.graph.EdgeWeightDigraph;

/**
 * 无负数SPT解决方案
 *
 * @author bule_ann
 * @since 2022/2/14
 */
public class DijkstraSPT implements ShortestPath {

    private EdgeWeightDigraph edgeWeightDigraph;

    public DijkstraSPT(EdgeWeightDigraph edgeWeightDigraph) {
        this.edgeWeightDigraph = edgeWeightDigraph;
    }

    @Override
    public float dist(int from, int to) {
        return 0;
    }

    @Override
    public Iterable<DefaultDirectedEdge> path(int from, int to) {
        return null;
    }

    private void relax(DirectedEdge directedEdge) {

    }


}
