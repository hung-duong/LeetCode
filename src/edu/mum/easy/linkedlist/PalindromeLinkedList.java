package edu.mum.easy.linkedlist;

import edu.mum.Utils.ListNode;

/**
 * Created by hungduong on 1/27/17.
 */
public class PalindromeLinkedList {
    //This can be solved by reversing the 2nd half and compare the two halves
    public boolean isPalindrome(ListNode head) {
        //In the beginning, set two pointers fast and slow starting at the head.
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Odd number of elements, need left move slow one step
        if(fast != null) {
            slow = slow.next;
        }

        //reverse the the 2nd half linked list
        slow = reverse(slow);
        fast = head;

        while(slow != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
