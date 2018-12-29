package com.dylan326.apus;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 较简单，主要是复杂度要求
 */
public class A34FindTargetStartAndEnd {

    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;
        int tmp = findBySecond(nums, 0, nums.length - 1, target);
        if (tmp == -1) {
            return new int[]{-1, -1};
        } else {
            start = tmp;
            end = tmp;
            while (start > 0) {
                if (nums[start - 1] == target) {
                    start--;
                } else {
                    break;
                }
            }

            while (end < nums.length - 1) {
                if (nums[end + 1] == target) {
                    end++;
                } else {
                    break;
                }
            }
            return new int[]{start, end};
        }
    }

    /**
     * 二分
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int findBySecond(int[] nums, int start, int end, int target) {

        while (start <= end) {
            if (target < nums[start] || target > nums[end]) {
                return -1;
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
        A34FindTargetStartAndEnd a34FindTargetStartAndEnd = new A34FindTargetStartAndEnd();
        System.out.println(Arrays.toString(a34FindTargetStartAndEnd.searchRange(new int[]{8},8)));
    }

}
