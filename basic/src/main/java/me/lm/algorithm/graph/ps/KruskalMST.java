package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.AdjacentListEWGraph;
import me.lm.algorithm.graph.Edge;
import me.lm.algorithm.graph.EdgeWeightGraph;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Consider edges in ascending order of weight.
 * Add next edge to tree T unless doing so would create a cycle.
 * P-判定环 S-union find (graph-DFS)
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public class KruskalMST implements MinSpannerTree {

    private Queue<Edge> mst = new ArrayDeque<>();

    private EdgeWeightGraph edgeWeightGraph;

    public KruskalMST(EdgeWeightGraph edgeWeightGraph) {
        this.edgeWeightGraph = edgeWeightGraph;
        doKMST(edgeWeightGraph);
    }

    private void doKMST(EdgeWeightGraph edgeWeightGraph) {
        //边排序
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        edgeWeightGraph.edges().forEach(edge -> edges.add(edge));
        //遍历
    }


    @Override
    public Iterable<Edge> edges() {
        return mst;
    }

    @Override
    public double weight() {
        return 0;
    }

    public static void main(String[] args) {
        EdgeWeightGraph edgeWeightGraph = new AdjacentListEWGraph();
        KruskalMST kmst = new KruskalMST(edgeWeightGraph);
        kmst.edges().forEach(System.out::println);
        System.out.println(kmst.weight());
    }
}
