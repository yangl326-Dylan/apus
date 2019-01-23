package com.dylan326.apus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * backtracking 模式， 回过头来之前的三数和或者三数靠近和， 回溯模式也能解决
 * 回溯解决的一类问题
 */
public class A39combinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {
            System.out.println("-----illegal="+Arrays.toString(tempList.toArray()));
            return;
        }
        else if (remain == 0) {
            System.out.println("found="+Arrays.toString(tempList.toArray()));
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                System.out.println("=add="+nums[i]+",array="+Arrays.toString(tempList.toArray()));
//                backtrack(list, tempList, nums, remain - nums[i], i+1);// start 参数取决于包不包含自己
                backtrack(list, tempList, nums, remain - nums[i], i);// 回溯开始位置从当前元素开始
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        A39combinationSum a39combinationSum = new A39combinationSum();
        System.out.println(Arrays.toString(a39combinationSum.combinationSum(new int[]{7, 2, 3, 4}, 7).toArray()));
    }
}
