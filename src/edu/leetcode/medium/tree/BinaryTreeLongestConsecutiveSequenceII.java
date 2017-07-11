package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

/**
 * Created by hungduong on 7/10/17.
 */
public class BinaryTreeLongestConsecutiveSequenceII {
    public static int longestConsecutive(TreeNode root) {
        if (root == null) return 0;

        int res = longestConsecutiveHelper(root, 1) + longestConsecutiveHelper(root, -1) + 1;

        return Math.max(res, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }

    public static int longestConsecutiveHelper(TreeNode node, int diff) {
        if (node == null) return 0;

        int inc = 0, dec = 0;
        if (node.left != null && node.val - node.left.val == diff) {
            inc = 1 + longestConsecutiveHelper(node.left, diff);
        }

        if (node.right != null && node.val - node.right.val == diff) {
            dec = 1 + longestConsecutiveHelper(node.right, diff);
        }

        return Math.max(inc, dec);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);

        int longest = longestConsecutive(root);

        System.out.print(longest);
    }
}
