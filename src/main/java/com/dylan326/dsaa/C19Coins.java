package com.dylan326.dsaa;

import java.util.Arrays;

/**
 * Created by dylan on 2023/10/8.
 * 找零钱问题
 */
public class C19Coins {
    /**
     * 可重复选
     *
     * @param coins  从小到大排序
     * @param amount 零钱
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int l = coins.length;
        int[][] results = new int[l][amount + 1];
        Arrays.fill(results[0], -1);
        for (int i = 0; i * coins[0] <= amount; i++) {
            results[0][i * coins[0]] = i;
        }
        for (int i = 1; i < coins.length; i++) { // i i面值的硬币； j 目标总面额
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i]) {
                    results[i][j] = results[i - 1][j];
                } else {
                    if (results[i - 1][j] == -1) {
                        results[i][j] = results[i][j - coins[i]] + 1;
                    } else if (results[i][j - coins[i]] == -1) {
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
     * 不可重复选
     *
     * @param coins  从小到大排序
     * @param amount 零钱
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        int l = coins.length;
        int[][] results = new int[l][amount + 1];
        Arrays.fill(results[0], -1);
        for (int i = 0; i * coins[0] <= amount; i++) {
            if (amount == coins[0]) {
                results[0][0] = 1;
            } else {
                results[0][i * coins[0]] = -1;
            }
        }

        for (int i = 1; i < coins.length; i++) { // i i面值的硬币； j 目标总面额
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i]) {
                    results[i][j] = results[i - 1][j];
                } else {
                    if (results[i - 1][j] == -1) {
                        results[i][j] = results[i - 1][j - coins[i]] + 1;
                    } else if (results[i][j - coins[i]] == -1) {
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
