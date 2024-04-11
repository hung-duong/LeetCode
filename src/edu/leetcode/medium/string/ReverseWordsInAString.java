package edu.leetcode.medium.string;

public class ReverseWordsInAString {

    // Soluton 1: 2 Pointer
    public static String reverseWords1(String s) {
        if (s.length() == 0)
            return "";

        String[] arrOfStr = s.trim().split("\\s+"); // Slipt one or more consecutive whitespaces
        int left = 0, right = arrOfStr.length - 1;
        while (left < right) {
            String tmp = arrOfStr[left];
            arrOfStr[left] = arrOfStr[right];
            arrOfStr[right] = tmp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrOfStr.length; i++) {
            sb.append(arrOfStr[i]);

            if (i != arrOfStr.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    // Soluton 2: Traverse from right to left
    public static String reverseWords2(String s) {
        if (s.length() == 0)
            return "";

        String[] arrOfStr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arrOfStr.length - 1; i > 0; i--) {
            sb.append(arrOfStr[i]);
            sb.append(" ");
        }

        return sb.append(arrOfStr[0]).toString();
    }

    public static void main(String[] args) {
        System.out.print(reverseWords1(" 3c      2zPeO dpIMVv2SG    1AM       o       VnUhxK a5YKNyuG     x9    EQ  ruJO       0Dtb8qG91w 1rT3zH F0m n G wU"));
    }
}
