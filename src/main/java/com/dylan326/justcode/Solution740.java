package com.dylan326.justcode;

import java.util.Arrays;

public class Solution740 {
    public static int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        result[0] = nums[0];
        if (nums.length == 1) {
            return result[0];
        }
        if ((nums[0] + 1) == nums[1]) {
            result[1] = Math.max(nums[0], nums[1]);
        } else {
            result[1] = nums[0] + nums[1];
        }
        int maxI = 0;
        for (int tmp : nums) {
            if (tmp >= maxI) {
                maxI = tmp;
            }
        }
        int[] record = new int[maxI + 1];
        for (int tmp : nums) {
            record[tmp] += 1;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                int front = record[nums[i - 1]];
                int back = record[nums[i]];
                int i1 = i - front - 1 >= 0 ? result[i - front - 1] : 0;
                if ((back * nums[i] + i1) > result[i - 1]) {
                    for (int j = 0; j < back; j++) {
                        result[i + j] = Math.max(result[i - 1], i1 + nums[i] * (j + 1));
                    }
                } else {
                    for (int j = 0; j < back; j++) {
                        result[i + j] = result[i - 1];
                    }
                }
                i = i + back - 1;
            } else {
                result[i] = result[i - 1] + nums[i];
            }
        }
        return result[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{1, 1, 2, 2, 3}));

    }
}
