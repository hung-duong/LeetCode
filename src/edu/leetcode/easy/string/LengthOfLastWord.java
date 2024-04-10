package edu.leetcode.easy.string;

public class LengthOfLastWord {
    // Solution 1: Built-in String Functions to remove leading and trailing spaces
    public int lengthOfLastWord1(String s) {
        String[] arrOfStr = s.trim().split(" ");

        if (arrOfStr.length == 0) 
            return 0;

        return arrOfStr[arrOfStr.length - 1].length();
    }

    // Solution 2: String Index Manipulation
    // We can break down the solution into two steps:
    // 1. We would try to locate the last word, start from len - 1 of string to 0. if we consume the empty " " space first.
    //      -> When we cross a non-space character, we know that we are at the last character of the last word.
    // 2. One we locate the last word, we count its length, starting from its last character. 
    public int lengthOfLastWord2(String s) {
        if (s != null && s.length() == 0)
            return 0;

        int pos = s.length() - 1;

        // 1. Try to locate the last word
        while(pos >= 0 && s.charAt(pos) == ' ') {
            pos--;
        }

        // Count its length, starting from its last character
        int length = 0;
        while(pos >= 0 && s.charAt(pos) != ' ') {
            length++;
            pos--;
        }

        return length;
    }

    // Solution 2: Same above but one-loop
    public int lengthOfLastWord3(String s) {
        if (s != null && s.length() == 0)
            return 0;

        int pos = s.length() - 1;
        int length = 0;

        while(pos >=0) {
            if (s.charAt(pos) != ' ') {
                length++;
            } else if (length > 0){
                return length;
            }
            pos--;
        }

        return length;
    }
}
