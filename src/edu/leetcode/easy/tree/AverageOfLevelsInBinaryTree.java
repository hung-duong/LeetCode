package edu.leetcode.easy.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hungduong on 7/9/17.
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * https://leetcode.com/contest/leetcode-weekly-contest-40/problems/average-of-levels-in-binary-tree/
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int queueSize = queue.size();
        while (queueSize > 0) {
            double val = 0;
            int size = queueSize;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                val += node.val;
                queueSize--;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(val / size);
            queueSize = queue.size();
        }

        return res;
    }
}
