package com.dylan326.justcode;

import java.util.Arrays;

public class StructData {
    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // 插入排序
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length; i++) { // 选择排序 最小最大的放进指定位置
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void popSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) { //  pop 优先确定最大或者最小的数据（依次交换到最终位置）
            for (int j = 1; j <= i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) { // 合并
        if (nums == null || nums.length < 2) {
            return;
        }
        int[] tmp = new int[nums.length];
        mergePrime(nums, tmp,0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergePrime(int[] nums, int[] result, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (r-l) / 2 + l;
        int start1 = l, end1 = m;
        int start2 = m + 1, end2 = r;
        mergePrime(nums, result, start1, end1);
        mergePrime(nums, result, start2, end2);
        int start = l; // 注意这个
        while (start1 <= end1 && start2 <= end2) {
            result[start++] = (nums[start1] < nums[start2]) ? nums[start1++] : nums[start2++];
        }
        while (start1 <= end1) {
            result[start++] = nums[start1++];
        }
        while (start2 <= end2) {
            result[start++] = nums[start2++];
        }
        for (int i = l; i <= r; i++) {
            nums[i] = result[i];
        }

    }

    public static void quickSort(int[] nums) {

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        popSort(new int[]{4, 3, 6, 7, 1, 3});
        insertSort(new int[]{4, 3, 6, 7, 1, 3});
        selectSort(new int[]{4, 3, 6, 7, 1, 3});
        mergeSort(new int[]{4, 3, 6, 7, 1, 3});

//        LinkedList a = new LinkedList();
//        a.add(1);
//        a.add(2);
//        System.out.println(a.getLast());
//
//        Stack stack = new Stack();
//        stack.peek();
//        stack.pop();
//        stack.add(1);
//        stack.remove(1);
//
//
//        Queue queue = new ArrayDeque();
//        queue.peek();
    }
}
