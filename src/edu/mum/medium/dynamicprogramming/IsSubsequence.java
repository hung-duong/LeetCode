package edu.mum.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/4/17.
 */
public class IsSubsequence {
    //Good but running time is too big
    public boolean isSubsequence01(String s, String t) {
        if (s == null || s.length() == 0)
            return true;

        if (t == null || t.length() == 0)
            return false;

        int indexS = 0;
        for(int indexT = 0; indexT < t.length(); indexT++) {
            if(s.charAt(indexT) == t.charAt(indexS)) {
                indexS++;
                if(indexS == s.length()) return true;
            }
        }

        return false;
    }

    //Improved performance
    public boolean isSubsequence02(String s, String t) {
        if (t.length() < s.length()) return false;

        int prev = 0;
        for(int indexS = 0; indexS < s.length(); indexS++) {
            char c = s.charAt(indexS);

            prev = t.indexOf(c, prev);

            if(prev == -1) return false;
            prev++;
        }

        return true;
    }
}
