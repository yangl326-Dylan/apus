package com.dylan326.apus;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dylan on 2017/9/21.
 * TODO
 */
public class A15Sum3 {
    public static List<List<Integer>> Sum3(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int tmp1 = i+1, tmp2 = nums.length -1;
            int tmp = target - nums[i];
            while (tmp1 < tmp2){

            }
            for (int j = i+1; j < nums.length ; j++) {
//                int tmp1 = j
            }
        }

    }

    public static void main(String[] args) {

    }
}
