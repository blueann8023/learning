package me.lm.basic.algorithm.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 连通组件
 * 常量时间判断两点是否连通、有路径、可达
 *
 * @author bule_ann
 * @since 2022/1/21
 */
public class ConnectedComponent implements Reachability {

    private Graph graph;

    public ConnectedComponent(Graph graph) {
        this.graph = graph;
        doCC(graph);
    }

    private int[] id;
    private boolean[] marked;
    private int count;

    private void doCC(Graph graph) {
        marked = new boolean[graph.countOfVertices()];
        id = new int[graph.countOfVertices()];
        for (int i = 0; i < graph.countOfVertices(); i++) {
            if (!marked[i]) {
                doDFS(graph, i);
                count++;
            }
        }
    }

    private void doDFS(Graph graph, int i) {
        marked[i] = true;
        id[i] = count;
        for (int w : graph.adjacent(i)) {
            if (!marked[w]) {
                doDFS(graph, w);
            }
        }
    }

    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }

    public Set<Integer> reachableVertices(int v) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < graph.countOfVertices(); i++) {
            if (id[i] == id[v]) {
                result.add(i);
            }
        }
        return result;
    }

}
