package com.dylan326.apus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dylan on 2017/9/21.
 */
public class A15Sum3 {

    /**
     * 直接处理方式
     *
     * @param nums
     * @param target
     * @return
     */
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
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (end > start && nums[end] == nums[end + 1]) {
                        end--;
                    }
                    result.add(tmp2);
                }
            }


        }
        return result;
    }

    /**
     * N数和或者和靠近处理模式
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> sum3New(int[] nums, int target) {
        Map<List<Integer>, List<Integer>> result = new HashMap<>();
        Arrays.sort(nums);
        sum3Backtracking(result, new ArrayList<Integer>(), nums, target, 0);
        return new ArrayList<>(result.values());
    }

    /**
     * backtracking 来处理
     *
     * @param result
     * @param item
     * @param nums
     * @param remain
     * @param start
     */
    public static void sum3Backtracking(Map<List<Integer>, List<Integer>> result, List<Integer> item, int[] nums, int remain, int start) {
        if (remain < nums[0]) {
            return;
        } else if (remain == 0 && item.size() == 3) { // 符合结果值
            result.put(new ArrayList<>(item), new ArrayList<>(item)); // 按照题目要求，简单用hashmap去重复数组
        } else {
            for (int i = start; i < nums.length; i++) {
                item.add(nums[i]);//* ① 添加当前元素
                sum3Backtracking(result, item, nums, remain - nums[i], i + 1); //* ② 之前的目标值为remain-nums[i]
                item.remove(item.size() - 1); // * ③ 回退元素
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(sum3(new int[]{0, 0, 0, 0, 0, 0}, 0));
        System.out.println(sum3New(new int[]{0, 0, 0, 0, 0, 0}, 0));
        //
        System.out.println(sum3(new int[]{-2, -1, 0, 1, 2, 3}, 0));
        System.out.println(sum3New(new int[]{-2, -1, 0, 1, 2, 3}, 0));
    }
}
