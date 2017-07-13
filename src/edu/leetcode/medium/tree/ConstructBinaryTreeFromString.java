package edu.leetcode.medium.tree;

import edu.common.Utils.TreeNode;

import java.util.Stack;

/**
 * Created by hungduong on 7/10/17.
 */
public class ConstructBinaryTreeFromString {
    public static TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || c == '-') {
                //Get the number
                int j = i;
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) < 0) j++;
                TreeNode node = new TreeNode(Integer.parseInt(s.substring(i, j + 1)));

                //Update i
                i = j;
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) parent.left = node;
                    else parent.right = node;
                }

                stack.push(node);
            } else if (c == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty() ? null : stack.peek();
    }

    public static void main(String args[]) {
        String str = "6(2(3)(1))(6(5))";

        TreeNode root = str2tree(str);

    }
}
