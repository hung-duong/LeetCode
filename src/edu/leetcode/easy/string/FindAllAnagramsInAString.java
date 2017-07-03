package edu.leetcode.easy.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 5/3/17.
 */
public class FindAllAnagramsInAString {
    //Solution 1: running time is O(n*k*logk) with n is the length of s and k is the length of p
    //Sort the p string
    //For each letter inside of s string, get next 3 letters and sorted them. If the next three letters
    //are equal to p, add the index

    //Solution 2: running time O(n)
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
            return res;

        //Because strings contain only the lowercase letters string => 26 characters
        int[] lowercase = new int[26];

        for(int i = 0; i < p.length(); i++) {
            lowercase[p.charAt(i) - 'a']++;
        }

        int left = 0, right = 0, count = p.length();
        while(right < s.length()) {
            if(lowercase[s.charAt(right++) - 'a']-- > 0)
                count--;

            if(count == 0)
                res.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if(right - left == p.length() && lowercase[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aaaabca";
        String p = "ba";

        List<Integer> res = findAnagrams(s, p);

        res.stream().forEach(System.out::println);
    }
}
