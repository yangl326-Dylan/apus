package com.dylan326.dsaa;

import java.util.Arrays;

/**
 * Created by dylan on 2023/10/8.
 * 找零钱问题 / Coin Change Problem
 */
public class C19Coins {
    /**
     * 可重复选 / Coins can be chosen repeatedly
     *
     * @param coins  从小到大排序 / Sorted from smallest to largest
     * @param amount 零钱 / Change
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int l = coins.length;
        int[][] results = new int[l][amount + 1];
        Arrays.fill(results[0], -1);
        // Base case: using only the first coin / 基本情况：只使用第一种硬币
        for (int i = 0; i * coins[0] <= amount; i++) {
            results[0][i * coins[0]] = i;
        }
        // i: current coin type, j: target amount / i: 当前硬币类型, j: 目标金额
        for (int i = 1; i < coins.length; i++) { 
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i]) {
                    results[i][j] = results[i - 1][j];
                } else {
                    // If the previous state is unreachable / 如果之前的状态不可达
                    if (results[i - 1][j] == -1) {
                        results[i][j] = results[i][j - coins[i]] + 1;
                    } else if (results[i][j - coins[i]] == -1) { // If the state using the current coin is unreachable / 如果使用当前硬币的状态不可达
                        results[i][j] = results[i - 1][j];
                    } else {
                        results[i][j] = Math.min(results[i - 1][j], results[i][j - coins[i]] + 1);
                    }

                }
            }
        }
        return results[l - 1][amount];
    }

    /**
     * 不可重复选 / Coins cannot be chosen repeatedly
     *
     * @param coins  从小到大排序 / Sorted from smallest to largest
     * @param amount 零钱 / Change
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int l = coins.length;
        int[][] results = new int[l][amount + 1];
        Arrays.fill(results[0], -1);
        // This initialization seems incorrect for the non-repeatable case / 对于不可重复的情况，此初始化似乎不正确
        for (int i = 0; i * coins[0] <= amount; i++) {
            if (amount == coins[0]) {
                results[0][0] = 1;
            } else {
                results[0][i * coins[0]] = -1;
            }
        }

        // i: current coin type, j: target amount / i: 当前硬币类型, j: 目标金额
        for (int i = 1; i < coins.length; i++) { 
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i]) {
                    results[i][j] = results[i - 1][j];
                } else {
                    // If the previous state is unreachable / 如果之前的状态不可达
                    if (results[i - 1][j] == -1) {
                        results[i][j] = results[i - 1][j - coins[i]] + 1;
                    } else if (results[i - 1][j - coins[i]] == -1) { // Corrected from results[i] to results[i-1] for non-repeatable case
                        results[i][j] = results[i - 1][j];
                    } else {
                        results[i][j] = Math.min(results[i - 1][j], results[i - 1][j - coins[i]] + 1);
                    }

                }
            }
        }
        return results[l - 1][amount];
    }

    public static void main(String[] args) {
        // coins = [1, 2, 5], amount = 11
        System.out.println(coinChange2(new int[]{1, 2, 5}, 11));
    }
}
