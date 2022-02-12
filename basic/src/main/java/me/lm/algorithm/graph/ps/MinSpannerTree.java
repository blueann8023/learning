package me.lm.algorithm.graph.ps;

import me.lm.algorithm.graph.Edge;

/**
 * 最小连接树
 * 核心理论-Cut connect to other cut by shortest edge must in MST
 * 基础算法- greedy 算法
 *
 * @author bule_ann
 * @since 2022/1/25
 */
public interface MinSpannerTree {
    Iterable<Edge> edges();

    double weight();
}
