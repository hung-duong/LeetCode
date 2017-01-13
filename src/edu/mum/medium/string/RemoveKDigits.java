package edu.mum.medium.string;

/**
 * Created by hungduong on 10/24/16.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if(k == 0) return num;

        if (k == num.length()) return "0";

        int pos = 0;
        StringBuilder str = new StringBuilder(num);

        while(k != 0 && pos < str.length() - 1) {
            if(str.charAt(pos) > str.charAt(pos + 1)) {
                str.deleteCharAt(pos);
                k--;
                if(pos > 0)
                    pos--;
            } else {
                pos++;
            }
        }

        if(k > 0) {
            str.delete(str.length() - k, str.length());
        }

        String result = str.toString();
        if(result.length() > 1) {
            result = result.replaceFirst("^0*", "");
        }

        return result.equals("") ? "0" : result;
    }

    public static void main(String[] args) {
        System.out.print(RemoveKDigits.removeKdigits("1234567890", 9));
    }
}
