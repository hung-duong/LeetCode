package edu.mum.medium.tree;

import edu.mum.Utils.TreeNode;

import java.util.Stack;

/**
 * Created by hungduong on 10/9/16.
 */
public class FlattenBinaryTreeToLinkedList {
    private static Stack<TreeNode> stack = new Stack<>();

    public static void flatten(TreeNode root) {
        flattenHelper(root);
    }

    public static void flattenHelper(TreeNode node) {
        if(node != null) {
            if(node.right != null) {
                stack.add(node.right);
            }

            if(node.left != null) {
                node.right = node.left;
                node.left = null;
            } else if(!stack.isEmpty()) {
                TreeNode p = stack.pop();
                node.right = p;
            }

            flattenHelper(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);

        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p3.right = p7;

        flatten(p1);
    }
}
