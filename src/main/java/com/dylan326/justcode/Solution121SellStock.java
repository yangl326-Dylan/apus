package com.dylan326.justcode;

public class Solution121SellStock {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i; j >=0 ; j--) {
                int tmp = prices[i] - prices[j];
                if(tmp>max){
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit= 0;
        int minPrice= prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit2(new int[]{7,1,5,3,6,4}));
    }
}
