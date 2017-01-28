package edu.mum.medium.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hungduong on 1/26/17.
 */
public class PalindromePartitioning {
    //Use Dynamic Programming + DFS
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] DP = new boolean[s.length()][s.length()];

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<=i; j++) {
                //i-j <= 2 <=> a, aa, aba
                if((s.charAt(i)==s.charAt(j)) && (i-j<=2 || DP[j+1][i-1])) {
                    DP[j][i] = true;
                }
            }
        }

        backtrack(s, 0, DP, new ArrayList<>(), result);

        return result;
    }

    public static void backtrack(String s, int pos, boolean[][] dp, List<String> path, List<List<String>> result) {
        if(pos == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=pos; i<s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos, i+1));
                backtrack(s, i+1, dp, path, result);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "aaabbc";

        List<List<String>> result = partition(s);

        for(List<String> ls : result) {
            System.out.print(ls);
        }
    }
}
