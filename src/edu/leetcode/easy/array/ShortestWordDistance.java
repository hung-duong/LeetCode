package edu.leetcode.easy.array;

/**
 * Created by hungduong on 1/11/17.
 */
public class ShortestWordDistance {
    /*Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
    For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    Given word1 = “coding”, word2 = “practice”, return 3.
    Given word1 = "makes", word2 = "coding", return 1.*/

    public static int shortestDistance(String[] words, String word1, String word2) {
        int posW1 = Integer.MAX_VALUE;
        int posW2 = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(word1.equals(words[i])) {
                posW1 = i;
                min = Math.min(min, Math.abs(posW1 - posW2));
            } else if(word2.equals(words[i])) {
                posW2 = i;
                min = Math.min(min, Math.abs(posW1 - posW2));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        String[] nums = {"practice", "makes", "perfect", "coding", "makes"};

        System.out.print(shortestDistance(nums, "coding", "makes"));
    }
}
