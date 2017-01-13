package edu.mum.medium.tree;

import edu.mum.Utils.TreeNode;

/**
 * Created by hungduong on 10/7/16.
 */
public class ConvertSortedArrayToBinarySearchTree {
    TreeNode root = null;

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return root;

        if(root == null) {
            int pos = nums.length / 2;
            root = new TreeNode(nums[pos]);

            root.left = addToNode(nums, 0, pos - 1);
            root.right = addToNode(nums, pos + 1, nums.length - 1);
        }

        return root;
    }

    public TreeNode addToNode(int[] nums, int first, int last) {
        if(first > last)
            return null;

        if(first == last)
            return new TreeNode(nums[first]);

        int pos = (last + first) / 2;

        TreeNode p = new TreeNode(nums[pos]);

        p.left = addToNode(nums, first, pos - 1);
        p.right = addToNode(nums, pos + 1, last);

        return p;
    }

    public static void main(String[] args) {
    }
}
