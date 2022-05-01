package me.lm.algorithm;

import java.util.*;

public class Solution {


    //链表
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    //有序二维数组查找，从右上角或左下角开始查找
    public boolean find2Array(int target, int[][] array) {

        int i = 0;
        int j = array[0].length - 1;
        while (i <= array.length - 1 && j >= 0) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    //旋转数组 查找：二分查找
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[right]) {
                right = mid;//45
            } else if (array[mid] == array[right]) {
                right = right - 1;//10111，11101
            } else {
                left = mid + 1;
            }
        }
        return array[left];
    }

    //数组 二分查找
    public int find2(int target, int[] array) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //字符串查找，参考String indexOf
    public int findString(char[] target, char[] source) {
        return 0;
    }

    //字符串替换
    public String replaceSpace(StringBuffer str) {
        //原数组替换
        //StringBuilder indexof or charat + replace 利用从前向后查找及内存拷贝
        //从前往后遍历 + 从后往前其替换
        //从前往后替换
        //新数组替换
        //String.replaceAll
        return str.toString().replaceAll(" ", "%20");
    }

    //最大公共子串
    public char[] findMaxCommonString(char[] a, char[] b) {
        //动态规划 矩阵 ：一维数组，起点以前以后 or 二维数组

        // 穷举
        return null;
    }


    //反转打印
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //stack
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
        //递归 ：实质也是栈结构
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            left = -left;
            result.add(temp);
        }
        return result;
    }


    //二叉树的层序遍历 II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.addFirst(temp);
        }
        return result;
    }

    //二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(temp);
        }
        return result;
    }

    // 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right) + 1, maxDepth(root.left) + 1);
    }

    //二叉树的最小深度
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        return Math.min(l + 1, r + 1);

    }


    //树
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);

        for (int i = 0; i > in.length; i++) {
            if (in[i] == treeNode.val) {
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i), Arrays.copyOfRange(in, 0, i - 1));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length - 1), Arrays.copyOfRange(in, i + 1, in.length - 1));
            }
        }

        return treeNode;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //当两个栈均为空时可以考虑抛出异常，我这里直接借助了stack pop自己的异常
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }


    //递归容易出现堆溢出，重复计算
    //使用迭代 n为整数
    public int Fibonacci(int n) {
        int a = 0, b = 1;
        while (n-- > 0) {
            a += b;
            b = a - b;
        }
        return a;
    }

    // >> >>> & 运算
    public int NumberOf1(int n) {
        // n 无符号右移
        /*int count = 0;
        while(n!=0){
            if((n&1)!=0){
                count ++;
            }
            n=n>>>1;
        }
        return count;*/
        //n&n-1可以将最右的1变为0
        /*int count = 0;
        while (n!=0){
            count++；
            n=n&(n-1);
        }
        return  count;*/
        // 左移
        /*int count =0,flag =1;
        while (flag!=0){
            if((n&flag)!=0){
                count++;
            }
            flag = flag<<1;
        }
        return  flag;*/
        //java
        return Integer.toBinaryString(n).replaceAll("0", "").length();
        // 将负数转为整数咯

    }

    public double Power(double base, int exponent) {
        // & + >>  + (1101 -> 1000 + 100 + 1);
        double result = 1d, current = base;
        int n = 0;
        if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            if (base == 0) {
                throw new RuntimeException("分母不为0");
            }
            n = -exponent;
        } else {
            return 1;
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= current;
            }
            current *= current;
            n >>= 1;
        }
        return exponent > 0 ? result : 1 / result;
        //循环迭代
        //递归 + 奇偶
    }

    public void reOrderArray(int[] array) {
        //插入排序
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int j = i - 1;
                int temp = array[i];
                while (j >= 0 && array[j] % 2 == 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
        //开辟新数组 归并
        /*int[] temp = new int[array.length];
        int i = 0, j = 0;
        while (i < array.length) {
            if (array[i] % 2 == 1) {
                temp[j++] = array[i];
            }
            i++;
        }
        i = 0;
        while (i < array.length) {
            if (array[i] % 2 == 0) {
                temp[j++] = array[i];
            }
            i++;
        }
        i = 0;
        while (i < array.length) {
            array[i] = temp[i];
            i++;
        }*/
    }
}
