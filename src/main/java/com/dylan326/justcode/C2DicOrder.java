package com.dylan326.justcode;

import java.util.Arrays;

/**
 * Created by dylan on 2017/6/6.
 * 字典序下个序列
 * permutation 排列
 */
public class C2DicOrder {

    //{1,2,6,5,4,3,0}
    public static int[] nextOrder(int[] a) {
        int flag = -1;
        int index = 0;
        for (int i = a.length - 1; i > 0; i--) { //找到第一个邻位递减的， 记录位置index
            if (a[i] > a[i - 1]) {
                flag = a[i - 1];
                index = i - 1;
                break;
            }
        }

        if (flag == -1) { // 没找到下一个， 直接返回自己
           /* for (int i = 0, j = a.length - 1; i < j; i++, j--) {  // 注释部分表示没有下一个 从头开始
                swap(a,i,j);
            }*/
            return a;
        }

        int delta = Integer.MAX_VALUE;
        int indexSwap = 0;
        for (int i = index + 1; i < a.length; i++) { // 找到index之后第一个比index位置值大的索引位置indexswap
            if (a[i] > flag && (a[i] - flag) < delta) {
                delta = (a[i] - flag);
                indexSwap = i;
            }
        }

        swap(a, index, indexSwap); // 交换 index  indexswap 两索引位置的值
        sortIncr(a, index + 1, a.length); // 对index 之后的位置升序排列
        return a;
    }

    private static void sortIncr(int[] a, int j, int length) {
        for (int i = j; i < length; i++) {
            for (int m = i; m < length; m++) {
                if (a[i] > a[m]) {
                    swap(a, i, m);
                }
            }
        }
    }

    private static void swap(int[] a, int index, int indexSwap) {
        int tmp = a[index];
        a[index] = a[indexSwap];
        a[indexSwap] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextOrder(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(nextOrder(new int[]{1,2,6,5,4,3,0})));
    }
}
