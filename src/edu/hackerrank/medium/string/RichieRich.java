package edu.hackerrank.medium.string;

/**
 * Created by hungduong on 7/4/17.
 */
public class RichieRich {
    static String richieRich(String s, int n, int k){
        char[] chars = s.toCharArray();

        //Count the number positions need to change
        int l = 0, r = n - 1, numChange = 0;
        while(l < r) {
            if(chars[l] != chars[r]) numChange++;
            l++;
            r--;
        }

        if(numChange > k) return "-1";

        //The number time we can change the both sides
        int bothChange = k - numChange;

        l = 0;
        r = n - 1;
        while(l < r) {
            char maxChar = (char) Math.max(chars[l], chars[r]);
            if(chars[l] != chars[r]) {
                if(maxChar != '9' && bothChange > 0) {
                    chars[l] = '9';
                    chars[r] = '9';
                    bothChange--;
                } else {
                    chars[l] = maxChar;
                    chars[r] = maxChar;
                    numChange--;
                }
            } else {
                if(maxChar != '9' && bothChange - 2 > 0) {
                    chars[l] = '9';
                    chars[r] = '9';
                    bothChange -= 2;
                }
            }
            l++;
            r--;
        }

        if(bothChange > 0 && l == r) {
            chars[l] = '9';
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        int n = 6;
        int k = 3;
        String s = "092282";
        String result = richieRich(s, n, k);
        System.out.println(result);
    }
}
