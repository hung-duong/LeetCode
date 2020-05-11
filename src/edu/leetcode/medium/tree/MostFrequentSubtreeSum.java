package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungduong on 7/8/17.
 */
public class MostFrequentSubtreeSum {
    static int maxCount = 0;
    static int n = 0;

    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};

        Map<Integer, Integer> histogram = new HashMap<>();

        findFrequentTreeSumHelper(root, histogram);

        int[] res = new int[n];
        int i = 0;
        for (Map.Entry entry : histogram.entrySet()) {
            if((int)entry.getValue() == maxCount) {
                res[i++] = (int)entry.getKey();
            }
        }

        return res;

    }

    public static int findFrequentTreeSumHelper(TreeNode root, Map<Integer, Integer> histogram) {
        if(root == null) return 0;

        int leftSum = findFrequentTreeSumHelper(root.left, histogram);
        int rightSum = findFrequentTreeSumHelper(root.right, histogram);

        int sum = root.val + leftSum + rightSum;

        int count = histogram.getOrDefault(sum, 0) + 1;
        histogram.put(sum, count);

        if (count > maxCount) {
            maxCount = count;
            n = 1;
        } else if (count == maxCount) {
            n++;
        }

        return sum;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        root.right.right.left.right.right = new TreeNode(12);

        int[] arr = findFrequentTreeSum(root);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
