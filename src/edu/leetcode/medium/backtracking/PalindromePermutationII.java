package edu.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/27/17.
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * For example:
 *      Given s = "aabb", return ["abba", "baab"].
 *      Given s = "abc", return [].
 */
public class PalindromePermutationII {
    /*
     * Hint:
     * If a palindromic permutation exists, we need to generate the first half of string
     * To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
     */
    public static List<String> generatePalindromes(String s) {
        int[] chars = new int[256];
        for(int i=0; i<s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        List<String> result = new ArrayList<>();
        int oddIndex = 0;
        boolean isFoundOdd = false;
        for(int i=0; i<chars.length; i++) {
            if((chars[i] & 1) == 1) {
                if(isFoundOdd) return result;
                isFoundOdd = true;
                oddIndex = i;
            }
        }

        String middle = "";
        if(isFoundOdd) {
            middle += (char)oddIndex;
            chars[oddIndex]--;
        }

        palindromePermutation(chars, middle, s.length(), result);

        return result;
    }

    public static void palindromePermutation(int[] chars, String middle, int n, List<String> result) {
        if(middle.length() == n) {
            result.add(middle);
            return;
        }

        for(int i=0; i<chars.length; i++) {
            if(chars[i] > 0) {
                chars[i] -= 2;
                palindromePermutation(chars, (char)i + middle + (char)i, n, result);
                chars[i] += 2;
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabbcee";
        List<String> result = generatePalindromes(str);

        for(String s : result) {
            System.out.println(s);
        }
    }
}
