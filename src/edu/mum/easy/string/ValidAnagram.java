package edu.mum.easy.string;

/**
 * Created by hungduong on 5/4/17.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        //Because strings contain only the lowercase letters string => 26 characters
        int[] lowercase = new int[26];

        for(int i = 0; i < s.length(); i++) {
            lowercase[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            lowercase[t.charAt(i) - 'a']--;
        }

        for(int i : lowercase) {
            if(i > 0) return false;
        }

        return true;
    }
}
