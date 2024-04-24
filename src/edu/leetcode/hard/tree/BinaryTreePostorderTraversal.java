package edu.leetcode.hard.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hungduong on 10/13/16.
 */
public class BinaryTreePostorderTraversal {
    List<Integer> integerList = new ArrayList<>();

    /* Solution 1
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return integerList;
        }

        postorderTraversalHelper(root);

        return integerList;

    }

    public void postorderTraversalHelper(TreeNode node) {
        if(node != null) {
            postorderTraversalHelper(node.left);
            postorderTraversalHelper(node.right);

            integerList.add(node.val);
        }
    }*/

    //Solution 2
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return integerList;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        TreeNode node = root;
        while(!stack.isEmpty()) {
            if(node.left != null) {
                node = node.left;
                stack.push(node);
            } else if(node.right != null) {
                node = node.right;
                stack.push(node);
            } else {
                integerList.add(node.val);
                node = stack.pop();
            }

        }

        return integerList;
    }

}
