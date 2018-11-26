package com.dylan326.apus;

import java.util.Arrays;

/**
 * Created by dylan on 2017/5/22.
 * 字典序的下一个数字, 如果没有则为原数组
 * 1,4,3,2 -> 2,1,3,4
 * 1,3,4,2 -> 1,4,2,3
 */
public class A31NextPermutation {

    public static int[] next(int[] nums) {
        int tmp1 = -1;
        int index1 = 0;
        for (int i = nums.length - 1; i > 0; i--) {//记录从右边开始查找，找到的第一个左邻位小的数
            if (nums[i - 1] < nums[i]) {
                tmp1 = nums[i - 1];
                index1 = i - 1;
                break;
            }
        }
        if (tmp1 == -1) { // 找不到则为字典序的最大值， 下一个按照题要求为回到最小值
//            return num;
            int m = 0, n = nums.length - 1;
            while (m < n) {
                int tmp = nums[m];
                nums[m] = nums[n];
                nums[n] = tmp;
            }
            return nums;
        }
        int delta = Integer.MAX_VALUE;
        int index2 = 0;
        for (int i = index1 + 1; i < nums.length; i++) {//找到比tmp1大的最小数
            if (nums[i] >= tmp1 && nums[i] - tmp1 < delta) {
                delta = nums[i] - tmp1;
                index2 = i;

            }
        }
        //swap
        nums[index1] = nums[index2];
        nums[index2] = tmp1;

        //sort index1+1~ num.lengh
        for (int i = index1 + 1; i < nums.length; i++) {// 对index1后面的数据按小到大排序
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(next(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(next(new int[]{1, 3, 2, 4})));
    }

}
