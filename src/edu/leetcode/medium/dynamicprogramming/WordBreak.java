package edu.leetcode.medium.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/5/17.
 */
public class WordBreak {
    //using the Recursion => TIME LIMIT EXCEEDED
    // Complexity: O(2^n) Consider the worst case where s = "abcd" and wordDict = [a, b, c, bc,ab,abc]
    // and every prefix of s is present in the dictionary of words, then the recursion tree can grow up to 2^n
    // Space: O(n) The depth of the recursion tree can go up to n.
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;

        StringBuilder str = new StringBuilder();

        for(int index = 0; index < s.length(); index++) {
            str.append(s.charAt(index));

            if(wordDict.contains(str.toString())) {
                if (wordBreak(s.substring(str.length(), s.length()), wordDict))
                    return true;
            }
        }

        return false;
    }

    //Breadth first-search
    // DP: Time O(n^2)
    //     space O(n)
    public static boolean wordBreakBFS(String s, List<String> wordDict) {
        return true;
    }


    //Improve performace
    // DP: Time O(n^2)
    //     space O(n)
    public static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
        String s = "ilikeicecreamandmango";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("like");
        wordDict.add("sam");
        wordDict.add("sung");
        wordDict.add("samsung");
        wordDict.add("mobile");
        wordDict.add("ice");
        wordDict.add("cream");
        wordDict.add("icecream");
        wordDict.add("i");
        wordDict.add("man");
        wordDict.add("go");
        wordDict.add("mango");
        wordDict.add("and");

        System.out.print(wordBreakDP(s, wordDict));
    }
}
