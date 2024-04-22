package edu.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    // Solution 1: Character/String Mapping with dictionary
    public boolean wordPattern1(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> mappingPToS = new HashMap<>();
        Map<String, Character> mappingSToP = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!mappingPToS.containsKey(c)) {
                mappingPToS.put(c, word);
            } else if (!mappingPToS.get(c).equals(word)) {
                return false;
            }

            if (!mappingSToP.containsKey(word)) {
                mappingSToP.put(word, c);
            } else if (!mappingSToP.get(word).equals(c)) {
                return false;
            }
        }

        return true;
    }

     // Solution 2: Same solution 1 but using 1 hashmap
     public boolean wordPattern2(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map mapping = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!mapping.containsKey(c)) {
                mapping.put(c, word);
            } else if (!mapping.get(c).equals(word)) {
                return false;
            }

            if (!mapping.containsKey(word)) {
                mapping.put(word, c);
            } else if (!mapping.get(word).equals(c)) {
                return false;
            }
        }

        return true;
    }
}
