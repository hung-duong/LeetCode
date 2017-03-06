package edu.mum.medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hungduong on 1/17/17.
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return result;

        String[] mapping = {"0", "1", "abc", "def",
                            "ghi", "jkl", "mno", "pqrs",
                            "tuv", "wxyz"};

        LinkedList<String> queue = new LinkedList<>();
        queue.add("");

        for(int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (queue.peek().length() == i) {
                String str = queue.pop();
                for(int j = 0; j < mapping[num].length(); j++) {
                    queue.add(str + mapping[num].charAt(j));
                }
            }
        }

        while(!queue.isEmpty()) result.add(queue.pop());

        return result;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("234");

        list.forEach(System.out::println);
    }
}
