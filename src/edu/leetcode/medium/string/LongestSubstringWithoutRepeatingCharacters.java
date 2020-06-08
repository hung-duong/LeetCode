package edu.leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hungduong on 9/18/16.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    //Solution 1
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        String strResult = null;
        String str = "";

        for(int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);

            if(!str.contains(Character.toString(character))) {
                str += character;
            } else {
                if(strResult == null || str.length() > strResult.length()) {
                    strResult = str;
                }

                //Remove all the characters from begin to duplicated character
                int indexOfDuplicated = str.indexOf(character);
                str = str.substring(indexOfDuplicated + 1, str.length());

                //Add character
                str += character;
            }
        }

        if(strResult == null || str.length() > strResult.length()) {
            strResult = str;
        }

        return strResult.length();
    }

    //Solution 2
    public static int lengthOfLongestSubstringImprove(String s) {
        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> hashMap = new HashMap<>();

        int pointer = 0;
        int max = 0;
        for(int index = 0; index < s.length(); index++) {
            char character = s.charAt(index);

            if(hashMap.containsKey(character)) {
                pointer = Math.max(pointer, hashMap.get(character) + 1);
            }

            hashMap.put(character, index);
            max = Math.max(max, index + 1 - pointer);

        }

        return max;
    }

    public static void main (String[] args) {
        String s = "pwwwkew";

        System.out.print(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstringImprove(s));
    }
}
