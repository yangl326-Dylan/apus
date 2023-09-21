package com.dylan326.apus;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class A26RemoveDuplicates {

    /**
     * 两个点， 输出长度， 形参的前长度位为结果
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int counter = 0;
        if (nums.length == 0) {
            return counter;
        }
        int tmp = nums[0];
        counter = 1;
        for (int i = 0; i < nums.length; i++) {
            if (tmp != nums[i]) {
                tmp = nums[i];
                nums[counter++] = tmp;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] tmp = new int[]{1,2,2,3,3,3,3,4};
        System.out.println(removeDuplicates(tmp));
        System.out.println(Arrays.toString(tmp));
    }
}
