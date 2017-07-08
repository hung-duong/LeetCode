package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hungduong on 7/8/17.
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int queueSize = queue.size();

        while (queueSize > 0) {
            long max = Long.MIN_VALUE;
            while (queueSize > 0) {
                TreeNode node = queue.poll();

                if(node.val > max) {
                    max = node.val;
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

                queueSize--;
            }

            res.add((int)max);

            queueSize = queue.size();
        }

        return res;
    }
}
