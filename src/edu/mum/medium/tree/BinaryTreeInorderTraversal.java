package edu.mum.medium.tree;

import edu.mum.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 10/7/16.
 */
public class BinaryTreeInorderTraversal {
    //Solution 1
    public List<Integer> lst = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversalHelper(root);

        return lst;
    }

    public void inorderTraversalHelper(TreeNode root) {
        if(root != null) {
            inorderTraversalHelper(root.left);
            lst.add(root.val);
            inorderTraversalHelper(root.right);
        }
    }

    //Solution 2: without recursion
}
