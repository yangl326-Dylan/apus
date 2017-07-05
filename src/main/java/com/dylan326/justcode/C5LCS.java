package com.dylan326.justcode;

/**
 * Created by dylan on 2017/6/19.
 */
public class C5LCS {

    public static void LCSprint(char[] a, char[] b) {
        int[][] result = new int[a.length+1][b.length+1];

        for (int i = 1; i <=a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = result[i][j - 1] > result[i - 1][j] ? result[i][j - 1] : result[i - 1][j];
                }
            }
        }

        for (int i = 0; i < a.length+1; i++) {
            for (int j = 0; j < b.length+1; j++) {
                System.out.print(result[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }

    }

    public static void main(String[] args) {
        LCSprint(new char[]{'a', 's', 'q', 'd', 'f'}, new char[]{'a', 'q', 'd', 'f'});
    }
}
