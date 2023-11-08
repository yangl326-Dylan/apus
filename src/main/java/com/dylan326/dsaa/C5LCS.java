package com.dylan326.dsaa;

/**
 * Created by dylan on 2017/6/19.
 * 最长公共子序列
 */
public class C5LCS {

    public static void LCSprint(char[] a, char[] b) {
        int[][] result = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < a.length; i++) { //状态转移方程
            for (int j = 1; j < b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                }
            }
        }
        // 遍历结果 可忽略
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(result[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        LCSprint(new char[]{'a', 's', 'q', 'd', 'f', 'g'}, new char[]{'a', 'q', 'd', 'c', 'g', 'f'});
    }
}
