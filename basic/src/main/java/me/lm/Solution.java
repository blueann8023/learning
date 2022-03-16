package me.lm;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/3/3
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here

        if (m==n){
            return head;
        }
        int count = 0;
        ListNode premNode = null;
        ListNode mNode = head;
        while (count <= m) {
            premNode = mNode;
            mNode = mNode.next;
            count++;
        }
        ListNode nNode = mNode;
        while (count <= n) {
            ListNode pre = nNode;
            ListNode next = nNode.next;
            nNode.next = pre;
            count++;
        }
        ListNode aftNNode = nNode.next;
        premNode.next = nNode;
        nNode.next = aftNNode;
        return head;
    }

    public class ListNode {

        public ListNode next;
        public int val;

    }
}
