package me.lm.basic.algorithm.search.balance;

import me.lm.basic.algorithm.search.SymbolTable;

/**
 * 左倾红黑树
 * perfect balance
 * symmetric order
 * binary search
 * APP-Database
 * @author bule_ann
 * @since 2021/12/28
 */
public class LeftLeanRedBlackTree<K, V> implements SymbolTable<K, V> {

    private Node<K, V> root;

    @Override
    public void put(Object key, Object value) {

    }

    @Override
    public Object get(Object key) {
        return null;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;
        private boolean isRed;

        public Node(K key, V value, boolean isRed) {
            this.key = key;
            this.value = value;
            this.isRed = isRed;
        }
    }


}
