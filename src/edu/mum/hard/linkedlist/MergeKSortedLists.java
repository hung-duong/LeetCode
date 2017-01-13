package edu.mum.hard.linkedlist;

import edu.mum.Utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hungduong on 10/19/16.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        //PriorityQueue is a sorted queue
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length,
                new Comparator<ListNode>() {
                    public int compare(ListNode a, ListNode b) {
                        if (a.val > b.val)
                            return 1;
                        else if(a.val == b.val)
                            return 0;
                        else
                            return -1;
                    }
                });

        //add first node of each list to the queue
        for (ListNode list : lists) {
            if (list != null)
                q.add(list);
        }

        ListNode head = new ListNode(0);
        ListNode p = head; // serve as a pointer/cursor

        while (q.size() > 0) {
            ListNode temp = q.poll();
            //poll() retrieves and removes the head of the queue - q.
            p.next = temp;

            //keep adding next element of each list
            if (temp.next != null)
                q.add(temp.next);

            p = p.next;
        }

        return head.next;
    }
}
