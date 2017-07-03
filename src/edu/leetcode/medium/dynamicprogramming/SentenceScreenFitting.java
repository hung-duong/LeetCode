package edu.leetcode.medium.dynamicprogramming;

/**
 * Created by hungduong on 1/3/17.
 * http://massivealgorithms.blogspot.com/2016/10/leetcode-418-sentence-screen-fitting.html
 */
public class SentenceScreenFitting {
    /*
     *sentence=["abc", "de", "f], rows=4, and cols=6.
     * "abc de f abc de f abc de f ..." // start = 0
     *  012345                          // start = start + cols + adjustment = 0 + 6 + 1 = 7 (1 space removed in screen string)
     *         012345                   // start = 7 + 6 + 0 = 13
     *               012345             // start = 13 + 6 - 1 = 18 (1 space added)
     *                    012345        // start = 18 + 6 + 1 = 25 (1 space added)
     *                           012345
     *
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";

        int len = s.length();
        int start = 0;

        for(int i = 0; i < rows; i++) {
            start += cols;
            if(start > 0 && s.charAt(start % len) == ' ') {
                start++;
            } else {
                while(start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }

        return start / len;
    }
}
