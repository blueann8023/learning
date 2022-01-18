package me.lm.basic.algorithm.search;

/**
 * key-value pairs
 *
 * @author bule_ann
 * @since 2021/12/22
 */
public interface SymbolTable<K , V> {

    void put(K key, V value);

    V get(K key);

//    boolean contains(Object key);
//
//    Object[] values();


}
