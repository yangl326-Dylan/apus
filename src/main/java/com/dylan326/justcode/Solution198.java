package com.dylan326.justcode;

public class Solution198 {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
        }
        return Math.max(f[nums.length - 2], f[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
