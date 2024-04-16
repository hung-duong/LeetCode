package edu.leetcode.medium.string;

import java.util.*;

/**
 * Created by hungduong on 2/27/17.
 */
public class GroupAnagrams {
    // Solution 1: Sorting
    //Time Limit Exceeded the running time O(nlogn + n*klogk)
    public List<List<String>> groupAnagrams01(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        //Sort the array
        Arrays.sort(strs);

        Map<String, List<String>> container = new HashMap<>();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = String.valueOf(chars);

            if(!container.containsKey(tmp))
                container.put(tmp, new ArrayList<String>());

            container.get(tmp).add(str);
        }

        return new ArrayList<List<String>>(container.values());
    }

    // Solution 2: Categorize by count
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String str : strs) {
            String newS = buildKey(str);

            if (!ans.containsKey(newS))
                ans.put(newS, new ArrayList<>());
            
            ans.get(newS).add(str);
        }

        return new ArrayList(ans.values());
    }

    private String buildKey(String str) {
        int[] chars = new int[26];

        for (int i=0; i<str.length(); i++) {
            chars[str.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            sb.append("#");
            sb.append(chars[i]);
        }

        return sb.toString();
    }


    //Use prime number to optimize running time for sorting
    //Running time is O(n*k)
    // This soltuon will be FAILED for test case:
    // Input: ["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"]
    // Current output: [["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"]]
    // Expected output:[["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"],["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"]]
    public List<List<String>> groupAnagrams02(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<List<String>>();

        //There are totally 26 numbers corresponding 26 letters in Alphabet
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        Map<Integer, List<String>> container = new HashMap<>();

        for(String str : strs) {
            int product = 1;
            for(Character c : str.toCharArray()) {
                product *= primes[c - 'a'];
            }

            if(!container.containsKey(product))
                container.put(product, new ArrayList<String>());

            container.get(product).add(str);
        }

        return new ArrayList<List<String>>(container.values());
    }
}
