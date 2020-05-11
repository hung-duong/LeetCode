package edu.hackerrank.medium.string;

import java.util.Arrays;

/**
 * Created by hungduong on 7/4/17.
 */
public class SherlockAndTheValidString {
    static String isValid(String s){
        //Assume that all characters [a-z]
        int[] histogram = new int[26];

        //Count the frequency of each letter appear in string
        for(int i = 0; i < s.length(); i++) {
            histogram[s.charAt(i) - 'a']++;
        }

        Arrays.sort(histogram);

        int i = 0;
        while (i < histogram.length && histogram[i] == 0) {
            i++;
        }

        int frequency = histogram[i];

        if(frequency == histogram[25]) return "YES";

        return (histogram[24] > frequency && histogram[25] > frequency) || (histogram[24] == frequency && histogram[25] > frequency + 1) ? "NO" : "YES";
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String s = in.next();
        String s = "aaabbbb";
        String result = isValid(s);
        System.out.println(result);
    }
}
