package edu.leetcode.medium.tree;

import edu.common.Utils.ListNode;
import edu.common.Utils.TreeNode;

/**
 * Created by hungduong on 7/11/17.
 */
public class ConvertSortedListToBinarySearchTree {
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildBST(head, null);
    }

    public static TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = buildBST(head, slow);
        node.right = buildBST(slow.next, tail);

        return node;
    }

    public static void main(String args[]) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        TreeNode root = sortedListToBST(node1);
    }
}
