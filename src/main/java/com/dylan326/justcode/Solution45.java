package com.dylan326.justcode;

import java.util.Arrays;

public class Solution45 {
    public static int jump(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            for (; j + nums[j] < i; j++) {
            }
            result[i] = result[j] + 1;
            System.out.println(Arrays.toString(result));
        }
        System.out.println("------");
        System.out.println(Arrays.toString(result));
        return result[nums.length - 1];
    }

    public static void main(String[] args) {
//        System.out.println(jump(new int[]{3, 2, 1}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
