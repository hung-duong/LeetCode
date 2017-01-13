/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.easy.math;

/**
 *
 * @author hungduong
 */
public class ReverseInteger {
    public int reverse(int x) {
        Queue<Integer> queue = new Queue<>();
        
        int y = x;
        int sign = 1;
        if(y < 0) {
            sign = -1;
            y = sign * y;
        }
        
        while(y != 0) {
            queue.enqueue(y % 10);
            y /= 10;
        }
        
        long rv = 0;
        while(!queue.isEmpty()) {
            int digit = queue.dequeue();
            rv = rv * 10 + digit;
            
            if (sign * rv > Integer.MAX_VALUE || sign * rv < Integer.MIN_VALUE) {
                return 0;
            }
        }
        
        return (int)(sign * rv);
    }
    
    public class Queue<T> {
        private int n;
        private Node first;
        private Node last;

        // Helper Node class
        private class Node {
            private T item;
            private Node next;
        }

        Queue() {
            first = null;
            last = null;
            n = 0;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return n;
        }

        public int length() {
            return n;
        }

        public T peek() {
            if (isEmpty()) throw new RuntimeException("Queue underflow");
            return first.item;
        }

        public void enqueue(T item) {
            Node oldNode = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldNode.next = last;
            n++;
        }

        public T dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue underflow");
            T item = first.item;
            first = first.next;
            n--;
            if (isEmpty()) last = null;
            return item;
        }
    }

    public static void main (String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int s = 1534236469;
        System.out.println(ri.reverse(s));
    }
}
