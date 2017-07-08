package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 7/7/17.
 */
public class FindLeavesOfBinaryTree {
    /**
     * Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.
     */
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        findLeavesHelper(res, root);

        return res;
    }

    public static int findLeavesHelper(List<List<Integer>> list, TreeNode node) {
        if(node == null) {
            return -1;
        }

        int left = findLeavesHelper(list, node.left);
        int right = findLeavesHelper(list, node.right);
        int curr = Math.max(left, right) + 1;

        if(list.size() <= curr) {
            list.add(new ArrayList<>());
        }

        list.get(curr).add(node.val);

        return curr;
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

        List<List<Integer>> list = findLeaves(root);

        for(List<Integer> l : list) {
            System.out.println(l);
        }
    }
 }