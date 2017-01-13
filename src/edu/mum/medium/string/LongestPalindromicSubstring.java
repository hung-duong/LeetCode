package edu.mum.medium.string;

/**
 * Created by hungduong on 9/30/16.
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();


        return s;
    }

    public static void main(String[] args) {
        String text = "   ABCDHGGjgrgb...erre.23235325!$#$";

        text = LongestPalindromicSubstring.longestPalindrome(text);
        System.out.print(text);
    }
}
