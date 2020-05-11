package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hungduong on 7/7/17.
 */
public class FindBottomLeftTreeValue {
    public static int findBottomLeftValue01(TreeNode root) {
        if (root == null) return 0;

        TreeNode maxNode = new TreeNode(root.val);
        int[] maxDepth = new int[]{1};

        findBottomLeftValueHelper(root, 1, maxDepth, maxNode);

        return maxNode.val;
    }

    public static void findBottomLeftValueHelper(TreeNode node, int depth, int[] maxDepth, TreeNode maxNode) {
        if (node == null) return;

        if (depth > maxDepth[0]) {
            maxDepth[0] = depth;
            maxNode.val = node.val;
        }

        findBottomLeftValueHelper(node.left, depth + 1, maxDepth, maxNode);
        findBottomLeftValueHelper(node.right, depth + 1, maxDepth, maxNode);
    }

    public static int findBottomLeftValue02(TreeNode root) {
        if (root == null) return 0;

        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return result;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);

        int leftNode = findBottomLeftValue02(root);

        System.out.println(leftNode);
    }
}
