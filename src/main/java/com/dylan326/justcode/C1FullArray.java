package com.dylan326.justcode;

import java.util.Arrays;

/**
 * Created by dylan on 2017/6/5.
 * 全排列递归方式理解
 * p[n] = 每个元素开头+剩下n-1个元素的全排列
 */
public class C1FullArray {

    public static void printFullArray(int[] a, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(a)); // 打印数组
        } else {
            for (int i = start; i <= end; i++) {// start  end 数组索引位置
                swap(a, start, i);// 从index=0开始交换
                printFullArray(a, start + 1, end);
                swap(a, start, i);// 数据需要复原；可以看某次递归深度的执行，即之后的每个元素交换到前面， 所以每次都是初始的复原位置开始
            }
        }

    }

    /**
     * 标准swap函数
     *
     * @param a
     * @param start
     * @param i
     */
    private static void swap(int[] a, int start, int i) {
        int tmp = a[start];
        a[start] = a[i];
        a[i] = tmp;
    }

    public static void main(String[] args) {
        printFullArray(new int[]{1, 2, 3, 4}, 0, 3);
    }
}
