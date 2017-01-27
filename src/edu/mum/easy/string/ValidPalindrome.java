package edu.mum.easy.string;

/**
 * Created by hungduong on 1/26/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;

        int lo = 0;
        int hi = s.length() - 1;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        while(lo < hi) {
            if(!Character.isLetterOrDigit(chars[lo])) {
                lo++;
            } else if(!Character.isLetterOrDigit(chars[hi])) {
                hi--;
            } else {
                if(chars[lo] == chars[hi]) {
                    lo++;
                    hi--;
                }
            }
        }

        return lo == hi;
    }
}
