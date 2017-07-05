package edu.hackerrank.easy.string;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by hungduong on 7/4/17.
 */
public class SuperReducedString {

    static String reducePairs(String s) {
        StringBuilder str = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < str.length() - 1) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                stack.push(i);
                i += 2;
            } else {
                i += 1;
            }
        }

        while (!stack.isEmpty()) {
            i = stack.pop();
            str.delete(i, i + 2);
        }

        return str.toString();
    }

    static String super_reduced_string(String s){
        if(s == null || s.length() == 0)
            return "Empty String";

        String str = s;
        boolean reducible = true;
        while (reducible) {
            String newStr = reducePairs(str);
            if(newStr.equals(str) || newStr.equals("")) {
                reducible = false;
            }

            str = newStr;
        }

        if(str.equals(""))
            return "Empty String";

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
