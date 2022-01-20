package me.lm.basic.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先搜索
 * IDEA-迷宫探索
 * APP-寻找Path、连通点
 * PhotoShop-FloodFill、垃圾回收算法的标记等
 * @author bule_ann
 * @since 2022/1/20
 */
public class PathsWithDFS implements Path {

    protected Graph graph;
    private int source;

    public PathsWithDFS() {
    }

    public PathsWithDFS(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        doDFS(graph, source);
    }

    private boolean[] marked;
    private int[] edgeTo;

    public void doDFS(Graph graph, int source) {

        marked[source] = true;
        for (Integer v : graph.adjacent(source)) {
            if (!marked[v]) {
                edgeTo[v] = source;
                doDFS(graph, v);
            }
        }

    }

    @Override
    public boolean hasPath(int to) {
        return marked[to];
    }

    // 无环的情况下是唯一的可 可以用
    @Override
    public Iterable<Integer> path(int to) {
        if (!hasPath(to)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = to; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }

    public Iterable<Integer> connectedSource() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Graph graph = new AdjacentListGraph();
        int source = 1;
        PathsWithDFS paths = new PathsWithDFS(graph, source);
        for (int i = 0; i < graph.countOfVertices(); i++) {
            if (paths.hasPath(i)) {
                System.out.println("path:" + source + "-" + i);
            }
        }
    }
}
