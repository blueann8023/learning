package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.Edge;
import me.lm.algorithm.graph.EdgeWeightGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/26
 */
public class PrimMST implements MinSpannerTree {

    private EdgeWeightGraph edgeWeightGraph;
    private Queue<Edge> mst;
    private boolean[] marked;
    PriorityQueue<Edge> queue;

    public PrimMST(EdgeWeightGraph edgeWeightGraph) {
        this.edgeWeightGraph = edgeWeightGraph;
        this.mst = new LinkedList<>();
        this.marked = new boolean[edgeWeightGraph.V()];
        this.queue = new PriorityQueue<>();
        doLazyPMST(edgeWeightGraph);
    }

    private void doEgerPMST(EdgeWeightGraph edgeWeightGraph) {
        // 没看懂
    }

    private void doLazyPMST(EdgeWeightGraph edgeWeightGraph) {
        visit(edgeWeightGraph, 0);
        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            int v = e.either();
            int w = e.other(v);
//            if (marked[v] & marked[w]) {
//                continue;
//            }
            mst.add(e);
            if (!marked[v]) {
                visit(edgeWeightGraph, v);
            }
            if (!marked[w]) {
                visit(edgeWeightGraph, w);
            }
        }
    }

    private void visit(EdgeWeightGraph edgeWeightGraph, int index) {
        marked[index] = true;
        edgeWeightGraph.adjacent(index).forEach(e -> {
            if (!marked[e.other(index)]) {
                queue.offer(e);
            }
        });
    }

    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return 0;
    }
}
