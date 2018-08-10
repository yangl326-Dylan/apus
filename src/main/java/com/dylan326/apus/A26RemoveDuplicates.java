package com.dylan326.apus;

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
    public int removeDuplicates(int[] nums) {
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

    }
}
