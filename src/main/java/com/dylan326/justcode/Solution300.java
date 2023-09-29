package com.dylan326.justcode;

import java.util.Arrays;

public class Solution300 {
    public static int lengthOfLIS(int[] nums) {
        int[] result = new int[nums.length];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
            if (result[i] > max) {
                max = result[i];
            }
        }
        System.out.println(Arrays.toString(result));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    }
}
