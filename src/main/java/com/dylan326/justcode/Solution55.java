package com.dylan326.justcode;

public class Solution55 {
    public static boolean canJump(int[] nums) {
        int maxLength = nums[0] + 1;
        for (int i = 0; i < nums.length; i++) {
            if (maxLength >= nums.length) {
                return true;
            }
            if (i > maxLength -1 ) {
                return false;
            }
            int tmp = nums[i] + i + 1;
            if (tmp > maxLength) {
                maxLength = tmp;
            }


        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0,2,3}));
    }
}
