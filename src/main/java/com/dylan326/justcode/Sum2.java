package com.dylan326.justcode;

public class Sum2 {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int index0 = 0;
        int index1 = 0;
        for (int i = 0; i < nums.length; i++) {
            index0 = i;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] == (target - nums[i])) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{index0, index1};
    }
}

