package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.DefaultDirectedEdge;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/2/5
 */
public interface ShortestPath {


    float dist(int from, int to);// source-sink

    Iterable<DefaultDirectedEdge> path(int from, int to);
}
