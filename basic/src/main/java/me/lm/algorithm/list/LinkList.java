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
        head = reverse(head);
    }

    public Node reverse(Node head) {
        if (head == null) {
            return head;
        }
        Node<T> pre = head;
        Node<T> cur = head.next;
        while (cur != null) {
            pre = cur;
            cur = cur.next;
            cur.next = pre;
        }
        return pre;
    }

    @Override
    public void reverseByGroup(int k) {
        if (head == null) {
            return;
        }
        reverseByGroup(this.head, k);
    }

    private Node reverseByGroup(Node<T> head, int k) {

        // 探测
        Node kNode = getK(head, k);
        if (kNode == null) {
            return head;
        }
        // 切割
        Node nextHead = kNode.next;
        kNode.next = null;
        Node preHead = reverse(head);
        Node newHead = reverseByGroup(nextHead, k);
        return null;
    }

    private Node getK(Node<T> head, int k) {
        return new Node();
    }

    private static class Node<T> {
        T value;
        Node<T> next;
    }

}
