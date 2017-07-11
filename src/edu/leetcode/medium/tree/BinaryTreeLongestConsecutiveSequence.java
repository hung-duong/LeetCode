package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by hungduong on 7/10/17.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public static int longestConsecutive01(TreeNode root) {
        if (root == null) return 1;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(root.val, 1);

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueSize = new LinkedList<>();

        queue.offer(root);
        queueSize.offer(1);

        int size = queue.size();

        int maxLengthPath = 1;
        while (size > 0) {
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int len = queueSize.poll();

                if (node.left != null) {
                    int left = len;
                    if(node.left.val == node.val + 1) {
                        left++;
                        maxLengthPath = Math.max(maxLengthPath, left);
                    } else {
                        left = 1;
                    }

                    queue.offer(node.left);
                    queueSize.offer(left);
                }

                if (node.right != null) {
                    int right = len;
                    if(node.right.val == node.val + 1) {
                        right++;
                        maxLengthPath = Math.max(maxLengthPath, right);
                    } else {
                        right = 1;
                    }

                    queue.offer(node.right);
                    queueSize.offer(right);
                }
            }

            size = queue.size();
        }

        return maxLengthPath;
    }

    /**
     * Use Recursion
     */

    static int max = 0;
    public static int longestConsecutive02(TreeNode root) {

        longestConsecutiveHelper(root);

        return max;
    }

    public static int longestConsecutiveHelper(TreeNode root) {
        if (root == null) return 0;

        int l = longestConsecutiveHelper(root.left);
        int r = longestConsecutiveHelper(root.right);

        int fromLeft = 0;
        int fromRight = 0;

        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                fromLeft = l + 1;
            } else {
                fromLeft = 1;
            }
        } else {
            fromLeft = 1;
        }

        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                fromRight = r + 1;
            } else {
                fromRight = 1;
            }
        } else {
            fromRight = 1;
        }

        max = Math.max(max, fromLeft);
        max = Math.max(max, fromRight);

        return Math.max(fromLeft, fromRight);
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        int longest = longestConsecutive02(root);

        System.out.print(longest);
    }
}
