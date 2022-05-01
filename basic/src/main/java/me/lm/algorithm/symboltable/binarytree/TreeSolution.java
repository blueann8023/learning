package me.lm.algorithm.symboltable.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author bule_ann
 * @since 2022/3/21
 */
public class TreeSolution {

    TreeNode ans;

    //二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    //二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestorBinary(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
        return root;
    }

    //二叉树 路径总和 II
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, new LinkedList<>(), result, targetSum);
        return result;
    }

    public void pathSum(TreeNode root, LinkedList<Integer> path, List<List<Integer>> result, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.right == null && root.left == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            pathSum(root.left, path, result, targetSum);
            path.pollLast();
        }
        if (root.right != null) {
            pathSum(root.right, path, result, targetSum);
            path.pollLast();
        }

    }

    //路径总和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.right == null && root.left == null && targetSum == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }


    //二叉树的所有路径
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, "", result);
        return result;
    }

    public void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }
        sb.append("->");
        if (root.left != null) {
            binaryTreePaths(root.left, sb.toString(), result);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, sb.toString(), result);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
