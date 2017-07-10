package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 7/10/17.
 */
public class KthSmallestElementInABST {
    public static int kthSmallest01(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        kthSmallestHelper(root, k, list);

        return list.get(list.size() - 1);
    }

    public static void kthSmallestHelper(TreeNode node, int k, List<Integer> list) {
        if(node != null) {
            kthSmallestHelper(node.left, k, list);

            if (list.size() < k) list.add(node.val);

            kthSmallestHelper(node.right, k, list);
        }
    }

    /**
     * Solution 2: Does not use extra memory
     */
    public static int kthSmallest02(TreeNode root, int k) {
        int nums = countNodes(root.left);

        if (nums >= k) {
            return kthSmallest02(root.left, k);
        } else if (nums + 1< k) {
            return kthSmallest02(root.right, k - nums - 1);
        }

        return root.val;
    }

    public static int countNodes(TreeNode node) {
        if (node == null) return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        //root.left = new TreeNode(1);

        int i = kthSmallest02(root, 1);

        System.out.print(i);
    }
}
