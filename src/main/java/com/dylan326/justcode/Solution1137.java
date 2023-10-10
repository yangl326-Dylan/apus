package com.dylan326.justcode;

public class Solution1137 {

    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            int[] tri = new int[n + 1];
            tri[0] = 0;
            tri[1] = 1;
            tri[2] = 1;
            for (int i = 3; i < n + 1; i++) {
                tri[i] = tri[i - 1] + tri[i - 2] + tri[i - 3];
            }
            return tri[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }

}
