package edu.mum.easy.tree;

import edu.mum.Utils.TreeNode;

/**
 * Created by hungduong on 10/19/16.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        invertTreeHelper(root);

        return root;
    }

    public void invertTreeHelper(TreeNode node) {
        if(node != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            invertTreeHelper(node.left);
            invertTreeHelper(node.right);
        }
    }
}
