package com.dylan326.apus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dylan on 2017/5/22.
 * 待补充其他方案，
 * method 1、直接方法
 */
public class A1Sum2 {
    public static int[] a1Sum2Method1(int[] nums, int target) {
        int[] result = new int[]{0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }


    public static int[] a1Sum2Method2(int[] nums, int target) {
        int[] result = new int[]{0, 0};
        Map<Integer, Integer> tmp = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            tmp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            Integer j = tmp.get(target - nums[i]);
            if (j != null && j != i) { // 去除掉 自己的判定
                result[0] = i;
                result[1] = j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a1Sum2Method1(new int[]{2, 3, 5}, 5)));
        System.out.println(Arrays.toString(a1Sum2Method2(new int[]{2, 3, 5}, 5)));
    }
}
