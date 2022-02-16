package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.DefaultDirectedEdge;
import me.lm.algorithm.graph.DirectedEdge;

/**
 * 无负数环的SPT方案
 *
 * @author bule_ann
 * @since 2022/2/16
 */
public class BFordSPT implements NegativeCycle,ShortestPath{

    @Override
    public boolean hasNegativeCycle() {
        // 如果vertices v is update in phase v,has negative cycle
        return false;
    }

    @Override
    public Iterable<DirectedEdge> negativeCycle() {
        return null;
    }

    @Override
    public float dist(int from, int to) {
        return 0;
    }

    @Override
    public Iterable<DefaultDirectedEdge> path(int from, int to) {
        return null;
    }
}
