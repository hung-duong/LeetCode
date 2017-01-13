package edu.mum.easy.tree;

import edu.mum.Utils.TreeNode;

/**
 * Created by hungduong on 10/8/16.
 */
public class MinimumDepthOfBinaryTree {

    //Solution: Recursion
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int depthLeft = 1 + minDepth(root.left);
        int depthRight = 1 + minDepth(root.right);

        return (depthLeft == 1 || depthRight == 1) ? depthLeft +  depthRight - 1 : Math.min(depthLeft, depthRight);
    }

    //Solution: Stack
    public int minDepthStack(TreeNode root) {
        return 0;
    }
}
