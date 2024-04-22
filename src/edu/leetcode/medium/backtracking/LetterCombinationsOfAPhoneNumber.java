package edu.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by hungduong on 1/17/17.
 * Algorithm T9
 */
public class LetterCombinationsOfAPhoneNumber {

    // Solution 1: Backtracking (DFS)
    private List<String> ans = new ArrayList<>();
    private Map<Character, String> mapping = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    private String phoneDigits;

    public void backtrack(int index, StringBuilder path) {
        // If the path have same length as digits, we have a complete combination
        if (path.length() == phoneDigits.length()) {
            ans.add(path.toString());
            return;
        }

        // Get the letters that the current digit maps to and loop through them
        String possibleLetters = mapping.get(phoneDigits.charAt(index));
        for (char c : possibleLetters.toCharArray()) {
            // Add the letter to current path
            path.append(c);

            // Call the backtrack for next possible
            backtrack(index + 1, path);

            // Remove the letter before moving to the next
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) {
            return ans;
        }

        phoneDigits = digits;
        backtrack(0, new StringBuilder());
        return ans;
    }

    // Solution 2: BFS
    //Running time: O(n^3) and O(3^n)
    public static List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return ans;

        String[] mapping = {"0", "1", "abc", "def",
                            "ghi", "jkl", "mno", "pqrs",
                            "tuv", "wxyz"};

        LinkedList<String> queue = new LinkedList<>();
        queue.add("");

        for(int i = 0; i < digits.length(); i++) {
            // Convert the digit to int
            int num = digits.charAt(i) - '0';

            // Will get all the combination in queue that have length = i
            // Like i = 0 -> get them empty
            //      i = 1 -> get single letter that push in queue at i = 0
            //      i = 2 -> get combinations that push in queue at i = 1 ...
            while (queue.peek().length() == i) {
                // Remove the top of queue and use the top to combine with next
                // letters in mapping
                String str = queue.pop();
                for(char c : mapping[num].toCharArray()) {
                    queue.add(str + c);
                }
            }
        }

        while(!queue.isEmpty()) 
            ans.add(queue.pop());

        return ans;
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations2("2345");

        list.forEach(System.out::println);
    }
}
