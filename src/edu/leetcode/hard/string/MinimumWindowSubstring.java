package edu.leetcode.hard.string;

/**
 * Created by hungduong on 5/18/17.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();

        if(lenS < lenT) return "";

        int[] arrS = new int[128];
        int[] arrT = new int[128];

        for(int index = 0; index < lenT; index++) {
            arrT[t.charAt(index)]++;
        }


        int minLen = Integer.MAX_VALUE;
        int startMin = -1, start = 0, count = 0;

        for(int index = 0; index < lenS; index++) {
            arrS[s.charAt(index)]++;

            if(arrT[s.charAt(index)] != 0 &&
                    arrS[s.charAt(index)] <= arrT[s.charAt(index)])
                count++;

            if(count == lenT) {
                //Find the new window and check if its length is
                // greater than current minLen or not
                while(arrS[s.charAt(start)] > arrT[s.charAt(start)] || arrT[s.charAt(start)] == 0) {
                    if(arrS[s.charAt(start)] > arrT[s.charAt(start)])
                        arrS[s.charAt(start)]--;
                    start++;
                }

                int windowLen = index - start + 1;
                if(minLen > windowLen) {
                    minLen = windowLen;
                    startMin = start;
                }
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(startMin, startMin + minLen);
    }

    public static void main(String[] args) {
        String s = "this is a test string";
        String t = "tist";

        System.out.print(minWindow(s, t));
    }
}
