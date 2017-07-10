package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.Observer;

/**
 * Created by hungduong on 7/8/17.
 */
public class BinaryTreeUpsideDown {
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;

        TreeNode node = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return node;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode node = upsideDownBinaryTree(root);
    }
}
