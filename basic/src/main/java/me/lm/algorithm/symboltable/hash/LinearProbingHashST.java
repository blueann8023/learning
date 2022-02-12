package me.lm.algorithm.symboltable.hash;

/**
 * 线性探测
 *
 * @author bule_ann
 * @since 2022/1/17
 */
public class LinearProbingHashST<K, V> {
    private int M = 30001;
    private V[] values = (V[]) new Object[M];
    private K[] keys = (K[]) new Object[M];

}
