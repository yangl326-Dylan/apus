package com.dylan326.justcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by dylan on 2017/6/5.
 * 全排列递归方式理解
 * p[n] = 每个元素开头+剩下n-1个元素的全排列
 * 递归思路理解：
 * 如果需要1~n元素的全排列， 那么1固定2~n的全排列，等等，直到n固定那么到达递归函数的的出口条件
 * 同理2开头
 * ...
 * ...
 * n开头
 */
public class C1FullArray {

    /**
     * backtracking 的结果集分为子集树 还是排列树， 这两套的代码结构模式有点不一样， 对于全排列如果使用回溯模式的话，结果集为排列树
     *
     * @param a
     * @param start
     * @param end
     */
    public static void printFullArray(int[] a, int start, int end) {
        if (start == end) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = start; i <= end; i++) {
                swap(a, start, i);
                printFullArray(a, start + 1, end);
                swap(a, start, i);// 数据需要复原；可以看某次递归深度的执行，即之后的每个元素交换到前面， 所以每次都是初始的复原位置开始
            }
        }

    }

    public static void printFullArray(int[] a) {
        Deque<Integer> tmp = new ArrayDeque<>();
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean jud[] = new boolean[nums.length];
        List<List<Integer>> valueList = new ArrayList<List<Integer>>();
        dfs(nums, -1, valueList, jud);
        return valueList;
    }

    private static void dfs(int[] nums, int index, List<List<Integer>> valueList, boolean[] jud) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (jud[i]) {
                list.add(nums[i]);
            }
        }
        valueList.add(list);
        for (int i = index + 1; i < nums.length; i++) {//第一个元素 或 当前元素不和前面相同  或者相同且前面被使用了可以继续进行
            if ((i == 0) || (nums[i] != nums[i - 1]) || (i > 0 && jud[i - 1] && nums[i] == nums[i - 1])) {
                jud[i] = true;
                dfs(nums, i, valueList, jud);
                jud[i] = false;
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
