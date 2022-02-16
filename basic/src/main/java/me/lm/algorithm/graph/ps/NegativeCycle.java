package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.DirectedEdge;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/2/16
 */
public interface NegativeCycle {

    boolean hasNegativeCycle();

    Iterable<DirectedEdge> negativeCycle();
}
