package me.lm.algorithm.symboltable.hash;

import me.lm.algorithm.symboltable.SymbolTable;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/17
 */
public class SeparateChainingHashST implements SymbolTable {

    private int M = 97;
    private Node[] st = new Node[M];

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public Object get(Object key) {
        return null;
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node next;
    }

}
