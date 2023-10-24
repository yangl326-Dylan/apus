package com.dylan326.justcode;

import java.util.Arrays;

public class Solution309 {

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        if (prices.length > 1) {
            if (prices[0] < prices[1]) {
                dp[1] = prices[1] - prices[0];
            } else {
                dp[1] = 0;
            }
        }
        if (prices.length > 2) {
            dp[2] = Math.max(Math.max(prices[2] - prices[1], prices[2] - prices[0]), Math.max(prices[1] - prices[0], 0));
        }
        for (int i = prices.length - 1; i > 2; i--) {
            if (prices[i] > prices[i - 1]) {
                int tmp = Math.max(dp[i - 3] + prices[i] - prices[i - 1], dp[i - 2]);
                dp[i] = Math.max(prices[i] - prices[i-3]+dp[i-3], tmp);
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{6,1,3,2,4,7}));

    }
}
