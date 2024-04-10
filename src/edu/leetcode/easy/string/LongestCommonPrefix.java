package edu.leetcode.easy.string;

public class LongestCommonPrefix {
    //Solution 1: Horizontal scanning
    // O(n*m) n is length of array and m is average len of all string in array

    // Using String -> 8s to complete all leetcode testcases
    // Why concatate String will be expensive?
    //      This means that whenever we concatenate a String, we will have the time complexity of O(N). 
    //      That happens because a new array of bytes will be created in memory and then will copy the String array into it.
    // public String commonSubString(String s1, String s2) {
    //     int len = s1.length() < s2.length() ? s1.length() : s2.length();

    //     String s = "";
    //     for (int i = 0; i < len; i++) {
    //         if (s1.charAt(i) == s2.charAt(i)) {
    //             s += s1.charAt(i); // Very expensive time it can cost O(m) or O(m^2) with m is average len of all string
    //         } else {
    //             break;
    //         }
    //     }
    //     return s;
    // }

    // Using StringBuilder -> 1 8s to complete all leetcode testcases
    public String LCP(String s1, String s2) {
        int len = s1.length() < s2.length() ? s1.length() : s2.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                // StringBuilder takes O(1) when appending single characters
                // But when appending a string is like calling addAll() -> cost is proportional to the length of the string
                sb.append(s1.charAt(i));   
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        
        String coPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            coPrefix = LCP(coPrefix, strs[i]);
            if (coPrefix.equals("")) {
                return "";
            }
        }

        return coPrefix;
    }

    //Solution 2: Vertial Scanning
    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        for(int i=0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        return strs[0];
    }
}
