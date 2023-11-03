package com.dylan326.justcode;

/**
 * Created by dylan on 2023/11/3.
 */
public class Solution53MaxSum {
    public static int maxSubSum(int[] a) {
        int[][] result = new int[a.length][a.length];
        result[0][0] = a[0];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (i == j) {
                    result[i][j] = a[i];
                } else {
                    result[i][j] = result[i][j - 1] + a[j];
                }
                max = Math.max(max, result[i][j]);
            }
        }
        return max;
    }

    public static int maxSubSumDp(int[] a) {
        int[] result = new int[a.length];
        result[0] = a[0];
        int max = result[0];
        for (int i = 1; i < a.length; i++) {
            result[i] = Math.max(result[i-1] + a[i], a[i]);
            max = Math.max(max,result[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubSumDp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
