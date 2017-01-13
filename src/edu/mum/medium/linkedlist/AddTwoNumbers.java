/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.linkedlist;

import edu.mum.Utils.ListNode;

/**
 *
 * @author hungduong
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l = l3;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0) {
            int va1 = l1 == null ? 0 : l1.val;
            int va2 = l2 == null ? 0 : l2.val;
            
            l.next = new ListNode((va1 + va2 + carry) % 10);
            l = l.next;
            l.next = null;
            
            carry = (va1 + va2 + carry) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        
        return l3.next;
    }
}
