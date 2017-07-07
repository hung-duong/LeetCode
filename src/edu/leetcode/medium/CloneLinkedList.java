package edu.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungduong on 7/5/17.
 */
public class CloneLinkedList {
    /**
     * Question: Clone a linked list with next and random pointer
     * Link: http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
     */

    class Node {
        int data;
        Node next, random; //Next and random reference

        public Node(int data) {
            this.data = data;
            this.next = this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (data != node.data) return false;
            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            return random != null ? random.equals(node.random) : node.random == null;
        }

        @Override
        public int hashCode() {
            int result = data;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            result = 31 * result + (random != null ? random.hashCode() : 0);
            return result;
        }
    }

    //Methode 1: O(n) running time and O(n) space
    public Node clone01(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node originNode = head, cloneNode = null;

        while (originNode != null) {
            cloneNode = new Node(originNode.data);

            map.put(originNode, cloneNode);
            originNode = originNode.next;
        }

        originNode = head;
        while (originNode != null) {
            cloneNode = map.get(originNode);
            cloneNode.next = map.get(originNode.next);
            cloneNode.random = map.get(originNode.random);

            originNode = originNode.next;
        }

        return map.get(head);
    }

    //Methode 2: O(n) running time and O(1) space
    // Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List,
    // create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N afte the Nth node
    public Node clone02(Node head) {
        Node originNode = head, tmp = null;

        while (originNode != null) {
            tmp = originNode.next;
            originNode.next = new Node(originNode.data);
            originNode.next.next = tmp;
            originNode = tmp;
        }

        originNode = head;
        while (originNode != null) {
            originNode.next.random = originNode.random.next;
            originNode = originNode.next != null ? originNode.next.next : originNode.next;
        }

        originNode = head;
        tmp = head.next;
        Node cloneNode = tmp;

        while (originNode != null) {
            originNode.next = originNode.next != null ? originNode.next.next : originNode.next;
            originNode = originNode.next;

            tmp.next = tmp.next != null ? tmp.next.next : tmp.next;
            tmp = tmp.next;
        }

        return cloneNode;
    }
}
