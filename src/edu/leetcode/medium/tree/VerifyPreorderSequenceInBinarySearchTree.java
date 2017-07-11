package edu.leetcode.medium.tree;

import java.util.Stack;

/**
 * Created by hungduong on 7/10/17.
 */
public class VerifyPreorderSequenceInBinarySearchTree {
    /**
     * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
     * You may assume each number in the sequence is unique.
     * Could you do it using only constant space complexity?
     */
    public static boolean verifyPreorder01(int[] preorder) {

        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;

        for (int i : preorder) {
            if (i < min) return false;

            while (!stack.isEmpty() && i > stack.peek()) {
                min = stack.pop();
            }

            stack.push(i);
        }

        return true;
    }


    //Solution 2: Does not use extra memory
    public static boolean verifyPreorder02(int[] preorder) {
        int index = -1;
        int min = Integer.MIN_VALUE;

        for (int i : preorder) {
            if (i < min) return false;

            while (index > -1 && i > preorder[index]) {
                min = preorder[index--];
            }

            preorder[++index] = i;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] preorder = {7, 5, 3, 6, 9, 8, 10};

        System.out.print(verifyPreorder02(preorder));
    }
}
