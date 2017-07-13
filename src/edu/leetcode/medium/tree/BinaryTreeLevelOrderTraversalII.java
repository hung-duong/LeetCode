package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hungduong on 7/12/17.
 */
public class BinaryTreeLevelOrderTraversalII {
    /**
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int queueSize = queue.size();
        while (queueSize > 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (list.size() > 0) res.add(0,list);
            queueSize = queue.size();
        }

        return res;
    }
}
