package edu.mum.medium.tree;

import edu.mum.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 10/10/16.
 *              /\     <-
 *             /  \    <-
 *            /        <-
 */
public class BinaryTreeRightSideView {
    List<Integer> lst = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return null;

        lst.add(root.val);
        rightSideViewHelper(root.right, 2);
        rightSideViewHelper(root.left, 2);

        return lst;
    }

    public void rightSideViewHelper(TreeNode node, int pos) {
        if (node != null) {
            if(pos > lst.size())
                lst.add(node.val);

            rightSideViewHelper(node.right, pos + 1);
            rightSideViewHelper(node.left, pos + 1);
        }
    }
}
