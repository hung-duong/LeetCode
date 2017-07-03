package edu.leetcode.easy.string;

/**
 * Created by hungduong on 1/27/17.
 * Question: Given a string, determine if a permutation of the string could form a palindrome.
 *           For example, "code" -> False, "aab" -> True, "carerac" -> True.
 */
 public class PalindromePermutation {
    public static boolean canPermutePalindrome(String s) {
        //Note a permutation of the string could form a palindrome when
        //There're unique a letter having the odd number and the rest should be even
        int[] nums = new int[128];
        for(int i=0; i<s.length(); i++) {
            nums[s.charAt(i)]++;
        }

        boolean isFoundOdd = false;
        for(int i=0; i<nums.length; i++) {
            if((nums[i] & 1) == 1) {
                if(isFoundOdd) return false;
                isFoundOdd = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "carerac";
        System.out.print(canPermutePalindrome(str));
    }
}
