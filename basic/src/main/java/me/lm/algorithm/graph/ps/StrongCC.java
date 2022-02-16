package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.Digraph;
import me.lm.algorithm.graph.Graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 有向图强连接组件
 * 核心理论
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public class StrongCC implements Reachability {
    private Digraph digraph;

    private int[] id;
    private boolean[] marked;
    private int count;

    private void doSCC(Digraph graph) {
        //还是没太明白这个算法的逻辑证明
        Digraph reverse = graph.reverse();
        Iterable<Integer> reversePostOrder = new DFS(reverse).topologicalSort();
        for (Integer i : reversePostOrder) {
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
        for (int i = 0; i < digraph.countOfVertices(); i++) {
            if (id[i] == id[v]) {
                result.add(i);
            }
        }
        return result;
    }
}
