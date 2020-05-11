package edu.leetcode.easy.tree;

import edu.common.Utils.TreeNode;

/**
 * Created by hungduong on 7/12/17.
 */
public class SymmetricTree {
    public static boolean isSymmetric01(TreeNode root) {
        if (root == null) return true;

        return isSymmetrichelper(root.left, root.right);
    }

    public static boolean isSymmetrichelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null || rightNode == null)
            return leftNode == rightNode;

        if (leftNode.val != rightNode.val)
            return false;

        return isSymmetrichelper(leftNode.left, rightNode.right) && isSymmetrichelper(leftNode.right, rightNode.left);
    }

    /**
     * Using stack
     */

    /*
    public static boolean isSymmetric02(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    }*/

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean isSys = isSymmetric01(root);

        System.out.print(isSys);
    }
}
