package edu.hackerrank.easy.string;

/**
 * Created by hungduong on 7/4/17.
 */
public class TwoCharacters {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        int len = 10;
        String s = "beabeefeab";

        char[] chars = s.toCharArray();
        int[] histogram = new int[26];
        for(int i = 0; i < chars.length; i++) {
            histogram[chars[i] - 'a']++;
        }

        int max = 0;
        for(int i = 0; i < histogram.length; i++) {
            for(int j = i + 1; j < histogram.length; j++) {
                if(histogram[i] != 0 && histogram[j] != 0
                        && (Math.abs(histogram[i] - histogram[j]) == 1)
                        || Math.abs(histogram[i] - histogram[j]) == 0) {
                    char c1 = (char)(i + 'a');
                    char c2 = (char)(j + 'a');

                    boolean isFound = true;
                    char prevChar = '*';
                    int count = 0;
                    for(int k = 0; k < len && isFound; k++) {
                        if(chars[k] == c1 && (prevChar == c2 || prevChar == '*')) {
                            prevChar = c1;
                            count++;
                        } else if (chars[k] == c2 && (prevChar == c1 || prevChar == '*')) {
                            prevChar = c2;
                            count++;
                        } else {
                            if(chars[k] == prevChar) {
                                isFound = false;
                            }
                        }
                    }

                    if(isFound) {
                        max = Math.max(max, count);
                    }
                }
            }
        }

        System.out.println(max);
    }
}
