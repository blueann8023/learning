package me.lm.basic.algorithm.search.binary;

import java.util.Iterator;

/**
 * 二进制搜索树
 * 实现min max等功能
 * lgN~N
 *
 * @author bule_ann
 * @since 2021/12/22
 */
public class BinarySearchTree<K extends Comparable<K>, V> implements OrderedSymbolTable<K, V>, Iterable {

    private Node<K, V> root;

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> root, K key, V value) {
        if (root == null) {
            return new Node<>(key, value, 1);
        }
        if (key.compareTo(root.key) > 0) {
            root.right = put(root.right, key, value);
        } else if (key.compareTo(root.key) < 0) {
            root.left = put(root.left, key, value);
        } else {
            root.value = value;
        }
        root.count = 1 + size(root.left) + size(root.right);
        return root;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.count;
    }

    @Override
    public V get(K key) {
        Node<K, V> i = root;
        while (i != null) {
            if (key.compareTo(i.key) > 0) {
                i = i.right;
            } else if (key.compareTo(i.key) < 0) {
                i = i.left;
            } else {
                return i.value;
            }
        }
        return null;
    }


    @Override
    public Iterator iterator() {
        return null;
    }


    @Override
    public V min() {
        return null;
    }

    @Override
    public V max() {
        return null;
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int rank) {
        return null;
    }


    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;
        private int count;

        public Node(K key, V value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
}
