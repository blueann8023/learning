package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.DefaultDirectedEdge;
import me.lm.algorithm.graph.DirectedEdge;
import me.lm.algorithm.graph.EdgeWeightDigraph;

/**
 * 无环SPT解决方案
 *
 * @author bule_ann
 * @since 2022/2/15
 */
public class AcyclicSPT implements ShortestPath {

    private EdgeWeightDigraph digraph;

    @Override
    public float dist(int from, int to) {
        DirectedEdge[] edgeTo = new DefaultDirectedEdge[digraph.V()];
        float[] distTo = new float[digraph.V()];
        //初始化distTo
        //计算topological sort
        //以topological sort，relax adjacent edges of vertices

        return 0;
    }

    @Override
    public Iterable<DefaultDirectedEdge> path(int from, int to) {
        return null;
    }
}
