package me.lm.algorithm.list;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/26
 */
public class LinkList<T> implements List<T> {

    private Node<T> head;

    @Override
    public void reverse() {
        if (head == null) {
            return;
        }
        Node<T> aft = head;
        Node<T> pre = head.next;
        while (pre != null) {
            Node<T> temp = pre.next;
            pre.next = aft;
            aft = pre;
            pre = temp;
        }
        head.next = null;
        head = aft;
    }

    private static class Node<T> {
        T value;
        Node<T> next;
    }

}
