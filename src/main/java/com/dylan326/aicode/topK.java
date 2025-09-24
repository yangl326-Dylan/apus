package com.dylan326.aicode;

import java.util.Arrays;

public class topK {
    /**
     * 使用快速选择算法实现的 topK 算法，返回数组中前 K 大的元素并排序
     * @param arr 输入的整型数组
     * @param k 前 K 大的元素
     * @return 前 K 大的元素组成的排序好的数组
     */
    public static int[] topK(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return new int[0];
        }
        if (k > arr.length) {
            k = arr.length;
        }

        // 使用快速选择找到第 K 大的元素
        quickSelect(arr, 0, arr.length - 1, arr.length - k);

        // 提取前 K 大的元素
        int[] result = Arrays.copyOfRange(arr, arr.length - k, arr.length);
        // 对结果进行排序
        Arrays.sort(result);

        return result;
    }

    /**
     * 快速选择算法
     * @param arr 输入数组
     * @param left 左边界
     * @param right 右边界
     * @param k 要找的第 k 小的元素的索引
     */
    private static void quickSelect(int[] arr, int left, int right, int k) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            if (pivotIndex == k) {
                return;
            } else if (pivotIndex < k) {
                quickSelect(arr, pivotIndex + 1, right, k);
            } else {
                quickSelect(arr, left, pivotIndex - 1, k);
            }
        }
    }

    /**
     * 分区操作
     * @param arr 输入数组
     * @param left 左边界
     * @param right 右边界
     * @return 分区点的索引
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    /**
     * 交换数组中两个元素的位置
     * @param arr 输入数组
     * @param i 索引 i
     * @param j 索引 j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int[] topKResult = topK(arr, k);
        System.out.println(Arrays.toString(topKResult));
    }
}
