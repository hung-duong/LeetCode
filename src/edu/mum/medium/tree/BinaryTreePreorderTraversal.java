package edu.mum.medium.tree;

import edu.mum.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 10/7/16.
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> lst = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalHelper(root);

        return lst;
    }

    public void preorderTraversalHelper(TreeNode root) {
        if(root != null) {
            lst.add(root.val);
            preorderTraversalHelper(root.left);
            preorderTraversalHelper(root.right);
        }
    }
}
