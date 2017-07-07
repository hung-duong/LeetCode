package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.*;

/**
 * Created by hungduong on 7/6/17.
 */
public class BinaryTreeVerticalOrderTraversal {
    /**
     * Print all nodes in vertical from right to left
     */
    public static void findMinMaxDistance(TreeNode node, int[] minmax, int hd) {
        if (node == null) return;

        if (minmax[0] > hd) {
            minmax[0] = hd;
        } else if (minmax[1] < hd) {
            minmax[1] = hd;
        }

        findMinMaxDistance(node.left, minmax, hd - 1);
        findMinMaxDistance(node.right, minmax, hd + 1);
    }


    public static void printBinaryTreeVertical(TreeNode node, int col, int hd) {
        if(node == null) return;

        if(col == hd)
            System.out.print(node.val + " ");

        printBinaryTreeVertical(node.left, col, hd - 1);
        printBinaryTreeVertical(node.right, col, hd + 1);
    }

    /**
     * Solution 1: O(w*n) with w is the width of tree.
     *  In worst case, the value of w can be O(n) and time complexity can become O(n2).
     */
    public static void printBinaryTreeVertical01(TreeNode root) {
        int[] minmax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        findMinMaxDistance(root, minmax, 0);

        for (int col = minmax[0]; col <= minmax[1]; col++) {
            printBinaryTreeVertical(root, col, 0);
            System.out.println("");
        }
    }

    /**
     * Solution 2: Use the HashMap to contain all the node have the same distance to root
     */
    public static void printBinaryTreeVertical02(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        traversalBinaryTree(root, map, 0);

        TreeSet treeSet = new TreeSet(map.keySet());
        Iterator it = treeSet.iterator();

        while (it.hasNext()) {
            Integer i = (Integer) it.next();
            System.out.println(map.get(i));
        }
    }

    public static void traversalBinaryTree(TreeNode node, Map<Integer, List<Integer>> map, int hd) {
        if(node == null) return;

        if(!map.containsKey(hd)) {
            map.put(hd, new ArrayList<>());
        }

        map.get(hd).add(node.val);

        traversalBinaryTree(node.left, map, hd - 1);
        traversalBinaryTree(node.right, map, hd + 1);
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

        System.out.println("vertical order traversal is :");
        printBinaryTreeVertical01(root);
    }
}
