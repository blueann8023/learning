package me.lm.basic.algorithm.search.binary;

import me.lm.basic.algorithm.search.SymbolTable;

/**
 * TODO
 * https://zhuanlan.zhihu.com/p/79224082
 *
 * @author bule_ann
 * @since 2021/12/22
 */
public interface OrderedSymbolTable<K, V> extends SymbolTable<K, V> {

    V min();

    V max();

    K floor(K key);

    K ceiling(K key);

    K select(int rank);

    int rank(K key);

}
