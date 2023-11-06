package com.dylan326.dsaa;

/**
 * Created by dylan on 2017/6/13.
 */
public class C4LIS {

    /**
     * 最长递增子序列个数
     *
     * @param a
     * @return
     */
    public static int LIS(int[] a) {
        int[] maxLength = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            maxLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    if (maxLength[i] < maxLength[j] + 1) {
                        maxLength[i] = maxLength[j] + 1;
                    }
                }
            }
            System.out.println(maxLength[i]);
        }
        int tmp = 0;
        for (int i = 0; i < maxLength.length; i++) {
            if (maxLength[i] > tmp) {
                tmp = maxLength[i];
            }
        }
        return tmp;
    }

    /**
     * DP
     *
     * @param a
     * @return
     */
    public static int LIS2DP(int[] a) {
        int[] maxLengthEnd = new int[a.length];
        maxLengthEnd[0] = 1;
        int result = 1;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    maxLengthEnd[i] = Math.max(maxLengthEnd[i], maxLengthEnd[j] + 1);
                }
                result = Math.max(result, maxLengthEnd[i]);
            }

        }

        return result;
    }

    /**
     * 倒序输出所有结果
     * 最长递增子序列
     *
     * @param a
     * @return
     */
    public static int[][] LISArray(int[] a) {
        int[] maxLength = new int[a.length];
        int[][] result = new int[a.length][a.length];

        for (int i = 0; i < a.length; i++) {
            maxLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && maxLength[i] <= maxLength[j] + 1) {
                    maxLength[i] = maxLength[j] + 1;
                }
            }
        }
        int tmp = 0;
        for (int i = 0; i < maxLength.length; i++) {
            if (maxLength[i] > tmp) {
                tmp = maxLength[i];
            }
        }

        for (int j = maxLength.length - 1; j >= 0; j--) { // 找到结果，开始递减的位置
            int flag = tmp;
            if (maxLength[j] != tmp) { //第一个最长结果位置才是后续代码的起点
                continue;
            }
            for (int i = j; i >= 0; i--) {
                if (maxLength[i] == flag) {
                    System.out.print(a[i]);
                    flag--;
                }
            }
            System.out.println("");
        }


        return result;
    }

    public static void main(String[] args) {
        LIS(new int[]{1, 7, 8, 3, 4});
        LISArray(new int[]{1, 7, 8, 3, 4});
    }
}
