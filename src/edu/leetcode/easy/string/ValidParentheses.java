package edu.leetcode.easy.string;

import java.util.Stack;

public class ValidParentheses {
    // Solution: Using Stack
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (char c : chars) {
            switch(c) {
                case '(':
                    st.push(')');
                    break;
                case '{':
                    st.push('}');
                    break;
                case '[':
                    st.push(']');
                    break;
                default:
                    if (st.isEmpty() || c != st.pop())
                        return false;
            }
        }

        return st.isEmpty();
    }
}
