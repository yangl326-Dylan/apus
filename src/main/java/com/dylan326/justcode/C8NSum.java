package com.dylan326.justcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dylan on 2017/9/21.
 */
public class C8NSum {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        nSum(new int[]{1, 0, -1, 0, -2, 1}, result, tmp, 0, 5, 4, 0);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(Arrays.toString(result.get(i).toArray()));
        }
    }

    /**
     * @param a 数组
     * @param i 数组索引起始
     * @param j 数组索引结束
     * @param n 层次
     * @param m 目标值
     */
    public static void nSum(int[] a, List<List<Integer>> result, List<Integer> tmp, int i, int j, int n, int m) {
        if (n == 1) {
            for (int k = i; k < j + 1; k++) {
                if (a[k] == m) {
                    tmp.add(m);
                    if (tmp.size() == 4 ) {
                        result.add(new ArrayList<>(tmp));
                    }
                    System.out.println("---end--- " + a[k]);
                    System.out.println(Arrays.toString(tmp.toArray()));
                    tmp.clear();

                } else {
                    System.out.println("XXXXXXXXXX");
                    tmp.clear();
                }
            }
            return;
        }
        if (i == j) {
            return;
        }

        for (int k = i; k < j + 1; k++) {
            System.out.println("add=" + a[k]);
            tmp.add(a[k]);
            nSum(a, result, tmp, k + 1, j, n - 1, m - a[k]);
        }
    }

}
