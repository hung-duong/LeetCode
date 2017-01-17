package edu.mum.medium.array;

/**
 * Created by hungduong on 1/16/17.
 */
public class BestTimeToBuyAndSellStockII {
    /*
     * Eg: [7, 2, 1, 10, 2, 5] => maxProfit = 12 = 10 - 1 + 5 - 2
     */
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1)
            return 0;

        int maxProfit = 0;
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
                maxProfit += max - min;
                min = Integer.MAX_VALUE;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        System.out.print(maxProfit(nums));
    }
}
