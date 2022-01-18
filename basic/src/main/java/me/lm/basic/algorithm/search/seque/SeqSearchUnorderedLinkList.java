package me.lm.basic.algorithm.search.seque;

import me.lm.basic.algorithm.search.SymbolTable;

/**
 * 顺序搜索-无序链表
 * maintain an unordered linked list of key-value pairs
 * search scan through all keys until find a match
 * insert scan .....
 * <p>
 * challenge
 *
 * @author bule_ann
 * @since 2021/12/22
 */
public class SeqSearchUnorderedLinkList<K, V> implements SymbolTable<K, V> {

    private Node head;

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    private static class Node<K, V> {
        private K key;
        private V value;
    }


}
