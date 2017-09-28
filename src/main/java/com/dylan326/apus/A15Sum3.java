package com.dylan326.apus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dylan on 2017/9/21.
 */
public class A15Sum3 {
    public List<List<Integer>> threeSum(int[] nums) { // 题目
        return null;
    }

    ;

    public static List<List<Integer>> sum3(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) { // 初始条件检查
            return result;
        }
        Arrays.sort(nums); // 排好序
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            int tmp = target - nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) { // 相等元素 继续下一个
                continue;
            }
            while (start < end) {
                if (tmp < nums[start] + nums[end]) {
                    end--;
                } else if (tmp > nums[start] + nums[end]) {
                    start++;
                } else {
                    List<Integer> tmp2 = new ArrayList<Integer>();
                    tmp2.add(nums[i]);
                    tmp2.add(nums[start]);
                    tmp2.add(nums[end]);
                    start++;
                    end--;
                    while(start<end && nums[start] == nums[start-1])
                    {
                        start++;
                    }
                    while(end>start && nums[end] == nums[end+1])
                    {
                        end--;
                    }
                    result.add(tmp2);
                }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sum3(new int[]{0, 0, 0, 0, 0, 0}, 0));
        System.out.println(sum3(new int[]{-2, -1, 0, 1, 2, 3}, 0));
    }
}
