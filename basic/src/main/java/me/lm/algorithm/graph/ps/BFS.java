package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度优先搜索
 * Solute Problem-(shortest) path｜cycle| bipartiteness
 * Graph APP -routing
 * Digraph APP -web crawler(爬虫)
 *
 * @author bule_ann
 * @since 2022/1/21
 */
public class BFS {

    protected Graph graph;
    private int source;


    public BFS(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        doBFS(graph, source);
    }


    private boolean[] marked;
    private int[] edgeTo;

    private void doBFS(Graph graph, int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            Integer item = queue.poll();
            for (Integer i : graph.adjacent(item)) {
                if (!marked[i]) {
                    marked[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
