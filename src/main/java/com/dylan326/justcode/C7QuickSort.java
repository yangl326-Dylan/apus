package com.dylan326.justcode;

import java.util.Arrays;

public class C7QuickSort {

    /**
     * 快速排序
     *
     * @param a
     * @param m
     * @param n
     */
    public static void quickSort(int[] a, int m, int n) {
        if (m < n) {
            int i = m;
            int j = n;
            int pivot = a[m];  // 枢纽元素为当前层级的数据第一个元素
            while (i < j) {
                while (i < j && a[j] > pivot) { // 找到右边第一个小于等于pivot的位置j，或者i=j
                    j--;
                }
                while (i < j && a[i] <= pivot) {// 找到左边第一个大于pivot的位置j，或者i=j。此处=由于选取的m作为枢纽，从m之后开始处理
                    i++;
                }
                if (i < j) { // i<j 交换ij位置的值，继续按此方法循环找ij位置
                    swap(a, i, j);
                } else if (i == j) {
                    swap(a, m, i);
                }
            } // 以上定位到枢纽元素pivot的索引位置i。找到后固定改位置，对i左边和右边的同样方法处理
            quickSort(a, m, i - 1);
            quickSort(a, i + 1, n);
        }
    }

    /**
     * 交换函数
     *
     * @param a
     * @param i
     * @param j
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void BubbleSorts(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void SelectSorts(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    swap(a, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = {6, 2, 1, 8, 7, 4, 6, 9};
//        quickSort(a, 0, a.length - 1);
        SelectSorts(a);
        System.out.println(Arrays.toString(a));
    }
}
