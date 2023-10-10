package com.dylan326.justcode;

import java.util.Arrays;

public class Solution322 {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dpArray = new int[coins.length][amount + 1];
        for (int i = 0; i < dpArray[0].length; i++) {
            dpArray[0][i] = -1;
        }
        for (int i = 0; i * coins[0] <= amount; i++) {
            dpArray[0][i * coins[0]] = i;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    if (dpArray[i][j - coins[i]] == -1) {
                        dpArray[i][j] = dpArray[i - 1][j];
                    } else if (dpArray[i - 1][j] == -1) {
                        dpArray[i][j] = dpArray[i][j - coins[i]] + 1;
                    } else {
                        dpArray[i][j] = Math.min(dpArray[i - 1][j], dpArray[i][j - coins[i]] + 1);
                    }
                } else {
                    dpArray[i][j] = dpArray[i - 1][j];
                }
            }
        }
        return dpArray[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
