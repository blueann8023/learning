package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.AdjacentListGraph;
import me.lm.algorithm.graph.Graph;

import java.util.*;

/**
 * 深度优先搜索
 * IDEA-迷宫探索
 * Solute Problem-Path｜Reachability｜ (euler!) cycle | topological sort｜ bipartite
 * Graph APP -PhotoShop-FloodFill
 * Digraph APP -垃圾回收算法的标记、程序控制流程、java compile、预先调度
 *
 * @author bule_ann
 * @since 2022/1/20
 */
public class DFS implements Path, Reachability, Cycle, Order {

    protected Graph graph;

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {
        Graph graph = new AdjacentListGraph();
        int source = 1;
        DFS paths = new DFS(graph);
        for (int i = 0; i < graph.countOfVertices(); i++) {
            if (paths.hasPath(source, i)) {
                System.out.println("path:" + source + "-" + i);
            }
        }
    }


    @Override
    public boolean hasPath(int from, int to) {
        boolean[] marked = new boolean[graph.countOfVertices()];
        doDFS(marked, from);
        return marked[to];
    }

    // 无环的情况下是唯一的可 可以用
    @Override
    public Iterable<Integer> path(int from, int to) {
        if (!hasPath(from, to)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
//        for (int x = to; x != from; x = edgeTo[x]) {
//            path.push(x);
//        }
//        path.push(from);
        return path;
    }

    @Override
    public Set<Integer> reachableVertices(int source) {
        boolean[] marked = new boolean[graph.countOfVertices()];
        doDFS(marked, source);
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public boolean haseCycle() {
        //访问状态记录
        return false;
    }

    @Override
    public Iterable<Integer> cycle() {
        return null;
    }

    @Override
    public Iterable<Integer> topologicalSort() {
        if (!haseCycle()) {
            return reversePostOrder();
        }
        return null;
    }

    private boolean[] doDFS(boolean[] marked, int source) {
        marked[source] = true;
        for (Integer v : graph.adjacent(source)) {
            if (!marked[v]) {
                doDFS(marked, v);
            }
        }
        return marked;
        // 还有一种栈
    }


    @Override
    public Iterable<Integer> reversePostOrder() {

        return null;
    }

    @Override
    public Iterable<Integer> postOrder() {
        return null;
    }
}
