package edu.leetcode.medium.dynamicprogramming;

import edu.common.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 10/9/16.
 */
public class UniqueBinarySearchTreesII {
    //Use Recursive (Divide and Conquer) solution
    public List<TreeNode> generateTrees01(int n) {
        if(n <= 0)
            return null;

        return generateTreesHelper(1, n);
    }

    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if(start == end) {
            TreeNode node = new TreeNode(start);
            list.add(node);

            return list;
        }

        if(start > end) {
            list.add(null);

            return list;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> lnodes = generateTreesHelper(start, i - 1);
            List<TreeNode> Rnodes = generateTreesHelper(i + 1, end);

            for(TreeNode lnode : lnodes) {
                for(TreeNode Rnode : Rnodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = Rnode;

                    list.add(root);
                }
            }
        }

        return list;
    }

    //Use DP solution
    public List<TreeNode> generateTrees02(int n) {
        return null;
    }
}
