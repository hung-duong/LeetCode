package edu.leetcode.medium.string;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num1 = st.pop();
                int num2 = st.pop();
                if (token.equals("+")) {
                    st.push(num1 + num2);
                } else if (token.equals("-")) {
                    st.push(num2 - num1);
                } else if (token.equals("*")) {
                    st.push(num1 * num2);
                } else if (token.equals("/")) {
                    st.push(((int) num2 / num1));
                }
            } else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}
