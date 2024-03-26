package edu.leetcode.hard.array;

/**
 * Created by hungduong on 4/19/17.
 */
public class BestTimeToBuyAndSellStockIII {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
    // Design an algorithm to find the maximum profit. You may complete at most two transactions.
    // Note: A transaction is a buy & a sell

    /*First idea:
    * - Go throw the array to find profits for each transaction and put inside array (Based on idea of BestTimeToBuyAndSellStockII)
    * - Then go the array and to find 2 max profits
    * - But this solution does not pass for case below
    *  arr = 1,2,4,2,5,7,2,4,9,0
    *  => profits = 0 0 3 0 0 5 0 0 7 0
    *  So the maxProfix = 5 + 7 = 12
    *  But the expectation is 13 (7 - 1 + 9 - 2 = 13)
    *  So, this algo does not work, should think about BestTimeToBuyAndSellStockI
    *  And maxProfit2 is the good solution
    *  */

    public static int maxProfit1(int[] prices) {  //This solution does not work
        if(prices == null || prices.length < 2)
            return 0;

        int[] profits = new int[prices.length];
        int min = Integer.MAX_VALUE;

        int i = 0;
        while(i < prices.length) {
            //find minimum
            while(i < prices.length && prices[i] <= min)
                min = prices[i++];

            int max = min;
            //find maximum
            while(i < prices.length && prices[i] >= max)
                max = prices[i++];

            if(max > min) {
                profits[i - 1] = max - min;
                min = Integer.MAX_VALUE;
            }
        }

        int max1, max2;
        max1 = max2 = profits[0];
        for (int j=1; j<profits.length; j++) {
            if (profits[j] >= max2) {
                max1 = max2;
                max2 = profits[j];
            } else if (profits[j] >= max1) {
                max1 = profits[j];
            }
        }

        for (int j=0; j<profits.length; j++)
            System.out.println(profits[j]);

        return max1 + max2;
    }

    // We can solve by "devide and conquer". We use left[i] to track the maximum profit for transactions before i,
    // and use right[i] to track the maximum profit for transactions after i.
    // Ex: Prices = 1  4  5  7  6  3  2  9
    //     left =  [0, 3, 4, 6, 6, 6, 6, 8]
    //     right=  [8, 7, 7, 7, 7, 7, 7, 0]
    //     maximum profit = 13
    //  O(N) and O(N) space
    public static int maxProfit2(int[] prices) {
        if(prices == null || prices.length < 2)
            return 0;

        //Highest profit in 0...i
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        //Maximum profit for transactions before i
        int min = prices[0];
        left[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //Maximum profit for transactions after i
        int max = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }

    // O(N) and O(1) space
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solutions/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems/
    // Case II: k = 2
    public static int maxProfit3(int[] prices) {
        int t_i10 = 0, t_i20 = 0;
        int t_i11 = Integer.MIN_VALUE, t_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            t_i20 = Math.max(t_i20, t_i21 + price);
            t_i21 = Math.max(t_i21, t_i10 - price);
            t_i10 = Math.max(t_i10, t_i11 + price);
            t_i11 = Math.max(t_i11, -price);
        }

        return t_i20; 
    }

    public static void main(String[] args) {
        int[] A = {1,2,4,2,5,7,2,4,9,0};
        //int[] A = {1, 1, 1, 1};
        System.out.print(maxProfit3(A));
    }
}
