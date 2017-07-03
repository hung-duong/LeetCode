package edu.leetcode.medium.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/7/17.
 */
public class DifferentWaysToAddParentheses {
    //It is similar method with UniqueBinarySearchTreesII
    public static List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0)
            return null;

        return diffWaysToComputeHelper(input, 0, input.length() - 1);
    }

    public static List<Integer> diffWaysToComputeHelper(String str, int start, int end) {
        List<Integer> list = new ArrayList<>();

        for(int i = start; i <= end; i++) {
            char c = str.charAt(i);

            if(c == '*' || c == '-' || c == '+') {
                List<Integer> lefts = diffWaysToComputeHelper(str, start, i - 1);
                List<Integer> rights = diffWaysToComputeHelper(str, i + 1, end);

                for(int l : lefts) {
                    for(int r : rights) {
                        list.add(calc(l, r, c));
                    }
                }
            }
        }

        if(list.size() == 0) {
            list.add(Integer.valueOf(str.substring(start, end + 1)));

            return list;
        }

        return list;
    }

    public static int calc(int m, int n, char op) {
        int result = 0;

        switch (op) {
            case '*':
                result = m * n;
                break;
            case '-':
                result = m - n;
                break;
            case '+':
                result = m + n;
                break;
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "2-1-2";

        List<Integer> list = diffWaysToCompute(str);

        list.stream().forEach(System.out::println);
    }
}
