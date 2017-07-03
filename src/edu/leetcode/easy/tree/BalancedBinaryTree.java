package edu.leetcode.easy.tree;

import edu.common.Utils.TreeNode;

/**
 * Created by hungduong on 4/26/17.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int maxDepth = maxDepth(root);
        int minDepth = minDepth(root);

        return (maxDepth - minDepth <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode node) {
        if(node == null)
            return 0;

        int max = 1 + Math.max(maxDepth(node.left), maxDepth(node.right));

        return max;
    }

    public int minDepth(TreeNode node) {
        if(node == null)
            return 0;

        int min = 1 + Math.min(maxDepth(node.left), maxDepth(node.right));

        return min;
    }
}
