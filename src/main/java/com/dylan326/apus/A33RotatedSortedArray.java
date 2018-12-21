package com.dylan326.apus;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,3,4,5,6] might become [5,6,0,1,2,3,4]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 思路类比二分， 变种，比较中位数和左右两个边界大小， 能确定哪半边是有序，哪半边是转置。再比较大小确target再哪半边，有序的采用二分查找，转置的回到了初始问题
 */
public class A33RotatedSortedArray {

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        if (nums.length == 0) {
            return -1;
        }
        if (target < nums[start] && target > nums[end]) {
            return -1;
        }
        if (target == nums[start] && start == end) {
            return start;
        }
        while (start <= end) {
            int index = (start + end) / 2;
            int tmp = nums[index];
            if (tmp == target) { // 找到目标
                return index;
            }
            if (tmp <= nums[end]) {
                if (target >= tmp && target <= nums[end]) { // target 在有序右侧
                    return searchSecond(nums, target, index, end);
                } else { // target在转置左侧，重新调整右边界
                    end = index - 1;
                }
            } else {
                if (target >= nums[start] && target <= tmp) { // target 在有序左侧
                    return searchSecond(nums, target, start, index);
                } else { //// target在转置左侧，重新调整左边界
                    start = index + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    private static int searchSecond(int[] nums, int target, int start, int end) {
        while (start <= end) {
            if (target < nums[start] || target > nums[end]) {
                return -1;
            }
            int index = (start + end) / 2;
            int tmp = nums[index];
            if (tmp == target) {
                return index;
            }
            if (target < tmp) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        A33RotatedSortedArray a33RotatedSortedArray = new A33RotatedSortedArray();
//        System.out.println(searchSecond(new int[]{1, 3}, 3, 0, 1));
        System.out.println(a33RotatedSortedArray.search(new int[]{4,5,6,1,2,3}, 2));
    }
}
