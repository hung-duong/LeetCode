package edu.leetcode.easy.tree;

import edu.common.Utils.TreeNode;

/**
 * Created by hungduong on 1/30/17.
 */
public class SameTree {
    //Given two binary trees, write a function to check if they are equal or not.
    //Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    //Solution:
    //  1.  Two trees are identical when they have same data and arrangement of data is also same.
    //  2.  To identify if two trees are identical, we need to traverse both trees simultaneously,
    //      and while traversing we need to compare data and children of the trees.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //1. The couple node is same empty
        if(p == null && q == null) {
            return true;
        }

        //2. Non empty for the both
        if(p != null && q != null) {
            return (p.val == q.val) && isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
        }

        //3. one empty, one not -> false
        return false;
    }
}
