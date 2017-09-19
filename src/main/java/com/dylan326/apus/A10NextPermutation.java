package com.dylan326.apus;

import java.util.Arrays;

/**
 * Created by dylan on 2017/5/22.
 * 字典序的下一个数字, 如果没有则为原数组
 * 1,4,3,2 -> 2,1,3,4
 * 1,3,4,2 -> 1,4,2,3
 */
public class A10NextPermutation {

    public static int[] next(int[] num) {
        int tmp1 = -1;
        int index1 = 0;
        for (int i = num.length - 1; i > 0; i--) {//记录从右边开始查找，找到的第一个左邻位小的数
            if (num[i - 1] < num[i]) {
                tmp1 = num[i - 1];
                index1 = i - 1;
                break;
            }
        }
        if (tmp1 == -1) {
            return num;
        }
        int delta = Integer.MAX_VALUE;
        int index2 = 0;
        for (int i = index1 + 1; i < num.length; i++) {//找到比tmp1大的最小数
            if (num[i] >= tmp1 && num[i] - tmp1 < delta) {
                delta = num[i] - tmp1;
                index2 = i;

            }
        }
        //swap
        num[index1] = num[index2];
        num[index2] = tmp1;

        //sort index1+1~ num.lengh
        for (int i = index1+1; i <num.length ; i++) {// 对index1后面的数据按小到大排序
            for (int j = i+1; j <num.length; j++) {
                if(num[i]>num[j]){
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(next(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(next(new int[]{1,3,2,4})));
    }

}
