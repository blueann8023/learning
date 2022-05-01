package me.lm.algorithm.list;

import me.lm.algorithm.Solution;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/1/26
 */
public class LinkListA implements ListA {

    private ListNode head;

    @Override
    public void reverse() {
        head = reverse(head);
    }

    //两两交换链表中的节点
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy, left = head, right;

        while (left != null && left.next != null) {

            right = left.next;

            ListNode next = right.next;
            right.next = left;
            pre.next = right;
            left.next = next;
            pre = left;
            left = next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode pre = dummy;
        ListNode end = pre;
        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                return dummy.next;
            }

            ListNode start = pre.next;
            ListNode nex = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = nex;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    //删除排序链表中的重复元素 II
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    //重排链表
    public void
    reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode bTempHead = slow.next;
        slow.next = null;

        ListNode aHead = head;
        ListNode bHead = reverse(bTempHead);
        ListNode aNext, bNext;
        while (aHead != null && bHead != null) {
            aNext = aHead.next;
            bNext = bHead.next;

            ListNode temp = aHead.next;
            aHead.next = bHead;
            bHead.next = temp;

            aHead = aNext;
            bHead = bNext;
        }
    }

    //环形链表 II
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode pre = head;
        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (pre != slow) {
                    pre = pre.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    //环形链表
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dump = new ListNode();
        dump.next = head;
        int i = 0;
        ListNode preN = dump;
        ListNode N = head;
        ListNode cur = head;
        while (cur != null) {
            i++;
            cur = cur.next;
            if (i > n) {
                preN = preN.next;
                N = N.next;
            }
        }
        preN.next = N.next;
        return dump.next;
    }
    // 链表反转 迭代
    public ListNode reverse(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 链表反转 递归
    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }

    // 单链表区间逆向
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

    //
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = new ListNode(0);
        ListNode pre = result;
        int nextValue = 0;
        while (cur1 != null || cur2 != null) {
            ListNode temp = null;
            if (cur1 != null && cur2 != null) {
                temp = new ListNode((cur1.val + cur2.val + nextValue) % 10);
                nextValue = (cur1.val + cur2.val + nextValue) / 10;
                cur1 = cur1.next;
                cur2 = cur2.next;
                pre.next = temp;
                pre = temp;
                continue;
            }
            if (cur2 != null) {
                temp = new ListNode((cur2.val + nextValue) % 10);
                nextValue = (nextValue + cur2.val) / 10;
                cur2 = cur2.next;
                pre.next = temp;
                pre = temp;
                continue;
            }
            temp = new ListNode((cur1.val + nextValue) % 10);
            nextValue = (cur1.val + nextValue) / 10;
            cur1 = cur1.next;
            pre.next = temp;
            pre = temp;
        }
        if (nextValue > 0) {
            pre.next = new ListNode(1);
        }
        return result.next;

    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
