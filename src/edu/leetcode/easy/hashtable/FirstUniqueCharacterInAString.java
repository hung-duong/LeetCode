/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.leetcode.easy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hungduong
 */
public class FirstUniqueCharacterInAString {
    //Solution 1: Bad (take a lot time due to time execution on Map)
    public int firstUniqCharSoln1(String s) {
        if(s == null || s.length() == 0) return -1;
        
        Map<Character, Integer> counts = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            if(counts.containsKey(c))
                counts.put(c, 1 + counts.get(c));
            else
                counts.put(c, 1);
        }
        
        int index = 0;
        while(index < s.length()) {
            if(counts.get(s.charAt(index)) == 1)
                break;

            index++;
        }
        
        if(index < s.length()) {
            return index;
        }
        
        return -1;
    }

    //Solution 2: Better (reduce operation time by using array)
    public int firstUniqCharSoln2(String s) {
        if(s == null || s.length() == 0) return -1;

        int[] counts = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            if(counts[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
