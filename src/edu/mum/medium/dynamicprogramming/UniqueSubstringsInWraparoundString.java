package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/3/17.
 */
public class UniqueSubstringsInWraparoundString {
    public static int findSubstringInWraproundString(String p) {
        if(p.length() == 0) return 0;

        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];
        count[p.charAt(0) - 'a'] = 1;

        // store longest contiguous substring ends at current position.
        int maxLengthCur = 1;

        for(int i = 1; i < p.length(); i++) {
            char c = p.charAt(i);
            char cPrev = p.charAt(i - 1);

            if(c - cPrev == 1 || cPrev - c == 25) {
                maxLengthCur++;
            } else {
                maxLengthCur = 1;
            }

            count[c - 'a'] = Math.max(count[c - 'a'], maxLengthCur);
        }

        int sum = 0;
        for(Integer i : count) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "zab";

        System.out.print(findSubstringInWraproundString(s));
    }
}
