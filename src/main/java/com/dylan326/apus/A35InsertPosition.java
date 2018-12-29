package com.dylan326.apus;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class A35InsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (target < nums[start]) {
                return start;
            }
            if (target > nums[end]) {
                return end + 1;
            }
            int index = (start + end) / 2;
            if (target == nums[index]) {
                return index;
            }
            if (target < nums[index]) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        A35InsertPosition a35InsertPosition = new A35InsertPosition();
        System.out.println(a35InsertPosition.searchInsert(new int[]{1,3,4,5},7));
    }
}
