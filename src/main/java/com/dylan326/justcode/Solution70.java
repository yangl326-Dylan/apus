package com.dylan326.justcode;

public class Solution70 {
    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {

        int[] result = new int[45];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
        System.out.println(climbStairs2(45));
    }
}
