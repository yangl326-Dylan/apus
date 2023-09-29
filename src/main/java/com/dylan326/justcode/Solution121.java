package com.dylan326.justcode;

public class Solution121 {
    public int maxProfit(int[] prices) {
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
}
