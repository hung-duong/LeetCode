package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hungduong on 10/10/16.
 * Use the BFS (Breadth-first search) algorithm
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lstContainer = new ArrayList<>();
        if(root == null)
            return lstContainer;

        List<Integer>  lst;

        Stack<TreeNode> stackLR = new Stack();
        Stack<TreeNode> stackRL = new Stack();

        TreeNode node;

        stackLR.push(root);

        while (!stackLR.isEmpty() || !stackRL.isEmpty()) {

            lst = new ArrayList<>();
            while (!stackLR.isEmpty()) {
                node = stackLR.pop();
                lst.add(node.val);

                if (node.left != null)
                    stackRL.push(node.left);

                if(node.right != null)
                    stackRL.push(node.right);
            }

            if(lst.size() > 0)
                lstContainer.add(lst);

            lst = new ArrayList<>();
            while (!stackRL.isEmpty()) {
                node = stackRL.pop();
                lst.add(node.val);

                if(node.right != null)
                    stackLR.push(node.right);

                if(node.left != null)
                    stackLR.push(node.left);

            }

            if(lst.size() > 0)
                lstContainer.add(lst);
        }

        return lstContainer;
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

        BinaryTreeZigzagLevelOrderTraversal abc = new BinaryTreeZigzagLevelOrderTraversal();
        abc.zigzagLevelOrder(p1);
    }
}
