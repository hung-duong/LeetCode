package edu.mum.medium.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/5/17.
 */
public class WordBreak {
    //using the Recursion => TIME LIMIT EXCEEDED
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;

        StringBuilder str = new StringBuilder();

        for(int index = 0; index < s.length(); index++) {
            str.append(s.charAt(index));

            if(wordDict.contains(str.toString())) {
                if (wordBreak(s.substring(str.length(), s.length()), wordDict))
                    return true;
            }
        }

        return false;
    }

    //Improve performace
    public static boolean wordBreakImprove(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
        String s = "ilikeicecreamandmango";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("like");
        wordDict.add("sam");
        wordDict.add("sung");
        wordDict.add("samsung");
        wordDict.add("mobile");
        wordDict.add("ice");
        wordDict.add("cream");
        wordDict.add("icecream");
        wordDict.add("i");
        wordDict.add("man");
        wordDict.add("go");
        wordDict.add("mango");
        wordDict.add("and");

        System.out.print(wordBreakImprove(s, wordDict));
    }
}
