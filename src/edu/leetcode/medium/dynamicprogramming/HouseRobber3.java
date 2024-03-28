package edu.leetcode.medium.dynamicprogramming;

import java.util.HashMap;

public class HouseRobber3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Solution 1: O(n^2)
    public int rob1(TreeNode root) {
        if (root == null) return 0;
        
        int ans = 0;

        if (root.left != null) {
            ans += rob1(root.left.left) + rob1(root.left.right);
        }

        if (root.right != null) {
            ans += rob1(root.right.left) + rob1(root.right.right);
        }

        return Math.max(ans + root.val, rob1(root.left) + rob1(root.right));
    }

    // Solution 2: Recursion using HashMap
    // Problem of solution 1: We obserse that the recursive approach we have overlapping subproblems lilke for root node we are calling on its 
    // grandchildren (root.left.left, root.left.right, root.right.left, root.right.right) and when we are on child node of root (root.left, root.right) 
    // then again we will need the data of those four nodes -> again calling it.
    // -> Recusrion+Overlapping SubProblems which can make you think of DP Approach.
    // Solution: Just store calculated answer for each node in HashMap and if we need the value for that node again at any point we will just do the map.get(node) and get the value.
    public int rob2(TreeNode root) {
        return helper2(root, new HashMap<>());
    }

    public int helper2(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        
        // If node already visited and have the anwser -> get from maps instead of calculating again
        if (map.containsKey(root)) return map.get(root);

        int ans = 0;

        if (root.left != null) {
            ans += helper2(root.left.left, map) + helper2(root.left.right, map);
        }

        if (root.right != null) {
            ans += helper2(root.right.left, map) + helper2(root.right.right, map);
        }

        ans = Math.max(ans + root.val, helper2(root.left, map) + helper2(root.right, map));

        // Put the anwser in map corresponding to current node
        map.put(root, ans);

        return ans;
    }

    //Solution 3: Gready Approach
    // O(n) and O(1) space
    public int rob3(TreeNode root) {
        int[] ans = helper3(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] helper3(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] leftSubtree = helper3(root.left);
        int[] rightSubtree = helper3(root.right);

        int robbed = root.val + leftSubtree[1] + rightSubtree[1];
        int noRobbed = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);

        return new int[]{robbed, noRobbed};
    }

}
