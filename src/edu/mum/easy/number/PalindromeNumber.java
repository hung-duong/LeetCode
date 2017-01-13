package edu.mum.easy.number;


/**
 * Created by hungduong on 10/1/16.
 */
public class PalindromeNumber {

    //Solution 1 better than solution 2
    public static boolean isPalindrome01(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int reverse = 0;
        int tmp = x;

        try {
            while(tmp != 0) {
                reverse = (reverse * 10) + (tmp % 10);

                if(reverse - tmp == 0)
                    return true;

                tmp = tmp / 10;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

        return x - reverse == 0;
    }

    //Solution 2
    public static boolean isPalindrome02(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;

        int div = 1;
        while(x / div > 10) {
            div *= 10;
        }

        while(x != 0) {
            int left = x / div;
            int right = x % 10;
            if( left != right)
                return false;
            x = (x % div) / 10;
            div /= 100;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean bo = PalindromeNumber.isPalindrome01(11);

        System.out.print(bo);
    }
}
