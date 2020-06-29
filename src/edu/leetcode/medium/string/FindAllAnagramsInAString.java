package edu.leetcode.medium.string;

import java.util.*;

/**
 * Created by hungduong on 5/3/17.
 */
public class FindAllAnagramsInAString {
    //Solution 1: running time is O(n*k*logk) with n is the length of s and k is the length of p
    //Sort the p string
    //For each letter inside of s string, get next k letters and sorted them. If the next k letters
    //are equal to p, add the index

    //Solution 2: Sliding Window with HashMap
    //O(Ns + Np) and O(1)
    public static List<Integer> findAnagrams2(String s, String p) {
        if(s.length() < p.length())
            return new ArrayList<>();

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> pCount = new HashMap<>();

        for (int i=0; i<p.length(); i++) {
            if (pCount.containsKey(p.charAt(i))) {
                pCount.put(p.charAt(i), pCount.get(p.charAt(i)) + 1);
            } else {
                pCount.put(p.charAt(i), 1);
            }
        }

//        for (Character ch : p.toCharArray()) {
//            if (pCount.containsKey(ch)) {
//                pCount.put(ch, pCount.get(ch) + 1);
//            } else {
//                pCount.put(ch, 1);
//            }
//        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            //Add more character from s to sCount
            char ch = s.charAt(i);
            if (sCount.containsKey(ch)) {
                sCount.put(ch, sCount.get(ch) + 1);
            } else {
                sCount.put(ch, 1);
            }

            //Remove character from left side of window
            if (i >= p.length()) {
                ch = s.charAt(i - p.length());
                if (sCount.get(ch) == 1) {
                    sCount.remove(ch);
                } else {
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }

            // Compare sliding window pCount (hashmap) with the reference (hashmap)
            if (pCount.equals(sCount)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }

    //Solution 3: Sliding Window with Array
    //O(Ns + Np) and O(1)
    public static List<Integer> findAnagrams3(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i=0; i<p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            sCount[ch - 'a']++;

            if(i >= p.length()) {
                ch = s.charAt(i - p.length());
                sCount[ch - 'a']--;
            }

            if (Arrays.equals(pCount, sCount)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }


    //Solution 3: running time O(n)
    public static List<Integer> findAnagrams4(String s, String p) {
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

        List<Integer> res = findAnagrams2(s, p);

        res.stream().forEach(System.out::println);
    }
}
