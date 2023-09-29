package com.dylan326.justcode;

public class Solution5 {

    public static String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        if (array.length <= 1) {
            return s;
        }
        int size = array.length;
        int[][] result = new int[size][size];
        int maxTmp = 1;
        int m = 0;
        int n = 0;
        for (int i = size - 1; i >= 0; i--) {
            result[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    if (j == i + 1) {
                        result[i][j] = 2;
                    } else {
                        if (result[i + 1][j - 1] > 0) {
                            result[i][j] = result[i + 1][j - 1] + 2;
                        }
                    }
                    if (result[i][j] > maxTmp) {
                        maxTmp = result[i][j];
                        System.out.println(maxTmp);
                        m = i;
                        n = j;
                    }
                }
            }
        }
        return s.substring(m, n + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));
    }
}
