package com.dylan326.justcode;

/**
 * Created by dylan on 2023/10/26.
 */
public class C22AverageK {
    public static int solution(int[] a, int k) {
        long[][] sum = new long[a.length][a.length];
        int result = -1;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (i == j) {
                    sum[i][j] = a[i];
                } else {
                    sum[i][j] = sum[i][j - 1] + a[j];
                }
                if (sum[i][j] == ((long) (j - i + 1) * k) && j - i + 1 > result) {
                    result = j - i + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 4, 1}, 2));
    }
}
