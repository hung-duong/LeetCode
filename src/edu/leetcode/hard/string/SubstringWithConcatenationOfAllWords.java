package edu.leetcode.hard.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    private Map<String, Integer> wordCount = new HashMap<String, Integer>();
    private int wordLen = 0;
    private int numWords = 0;
    private int window = 0;

    public boolean checkSubstring(String s) {
        //1. Clone the dictionary from wordCount and init wordUsed = 0
        Map<String, Integer> cpyWordCount = new HashMap<>(wordCount);
        int wordUsed = 0;

        //2. For each position in Substring which extracted from step  3 in Part 1.
        // - Extract each word in substring which have wordlen
        // - Check if that word existes in clone dictionary hashtable
        // - If yes -> decreasing the count of that word in dictionary by 1
        //             and increase wordUsed value by 1
        // - If no, return false -> this substring is not statisfied.
        for (int i = 0; i < window; i+=wordLen) {
            String word = s.substring(i, i + wordLen);
            if (cpyWordCount.getOrDefault(word, 0) > 0) {
                cpyWordCount.put(word, cpyWordCount.get(word) - 1);
                wordUsed++;
            } else {
                return false;
            }
        }

        return wordUsed == numWords;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // 1. Init variables
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        wordLen = words[0].length();
        numWords = words.length;
        window = numWords * wordLen;

        // 2. Create a wordCount hash tbales that contains the number
        // of each word in word bank
        for (String word: words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 3. Move window a long side of string s 
        //    1. Extract substring with len = window and current position
        //    2. If current substring containe all words in wordCount
        //          -> push current position in ans
        for (int pos = 0; pos <= sLen - window; pos++) {
            String subS = s.substring(pos, pos + window);
            if(checkSubstring(subS)) {
                ans.add(pos);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        
        SubstringWithConcatenationOfAllWords obj = new SubstringWithConcatenationOfAllWords();

        String[] words = {"foo","bar"};

        System.out.print(obj.findSubstring("barfoothefoobarman", words));
    }
}
