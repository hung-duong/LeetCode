/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium.string;

/**
 *
 * @author hungduong
 * @Link : https://leetcode.com/problems/mini-parser/
 */

public class MiniParser {
    /* Solution 1:
    public NestedInteger deserialize(string s) {
        Stack<NestedInteger> st = new Stack<>();

        int firstNum = 0;
        while(firstNum < s.length()) {
            boolean foundFirst = false;
            while(firstNum < s.length() && !foundFirst) {
                if(s.charAt(firstNum) >= '0' && s.charAt(firstNum) <= '9') {
                    foundFirst = true;
                } else {
                    firstNum++;   
                }
            }
            
            int sign = 1;
            if(firstNum > 0 && s.charAt(firstNum - 1) == '-') {
                sign = -1;
            }

            int nextNum = firstNum + 1;
            boolean foundNext = false;
            if(foundFirst) {
                while(nextNum < s.length() && !foundNext) {
                    if(s.charAt(nextNum) < '0' || s.charAt(nextNum) > '9') {
                        foundNext = true;
                    } else {
                        nextNum++;
                    }
                }
            } else {
                break;
            }
            
            NestedInteger newNI = new NestedInteger();
            st.push(newNI);
            NestedInteger peek = st.peek();
            peek.add(new NestedInteger(sign * Integer.parseInt(s.substring(firstNum, nextNum))));

            firstNum = nextNum;
        }
        
        NestedInteger ni = null;
        while(!st.empty()) {
            ni = st.pop();
            if(!st.empty()) {
                NestedInteger peek = st.peek();
                peek.add(ni);   
            }
        }
        
        return ni;
    }*/
    
    /*Solution 2:
    public NestedInteger deserialize(string s) {
        if(s == null || s.length() == 0) return null;
        
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger cur = null;
        int curValue = 0;
        int sign = 1;
        int pointer = 0;
        char c;
        
        while(pointer < s.length()) {
            c = s.charAt(pointer);
            
            switch(c) {
                case '[':
                    cur = new NestedInteger();
                    stack.push(cur);
                    cur = null;
                    pointer++;
                    break;
                case ',':
                    stack.peek().add(cur);
                    pointer++;
                    break;
                case ']':
                    if(cur!=null)
                        stack.peek().add(cur);
                        
                    cur = stack.pop();
                    pointer++;
                    break;
                default:
                    curValue = 0;
                    sign = 1;
                    if(c == '-') {
                        sign = -1;
                    }
                    
                    while(s.charAt(pointer) >= '0' && s.charAt(pointer) <= '9' && pointer < s.length()) {
                        curValue = curValue*10 + (s.charAt(pointer) - '0');
                        pointer++;
                    }
                    
                    cur = new NestedInteger(sign * curValue);
            }
        }
        
        return cur;
    }
    */
}
