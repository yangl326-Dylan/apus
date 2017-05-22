package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 很基础，组合排序的中间流程，我面试候选者有时会会考察这个题目
 */
public class A4MedianOfTwoSortedArray {
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int la = a.length;
        int lb = b.length;
        if (la == lb && lb == 0) {
            return 0;
        }
        if ((la + lb) % 2 == 0) {
            int m1 = (la + lb) / 2;
            int m2 = m1 + 1;
            return (findM(a, b, m1) + findM(a, b, m2)) * 1.0 / 2.0;
        } else {
            return findM(a, b, (la + lb + 1) / 2);
        }
    }

    /**
     * size(a) >size(b)
     *
     * @param a
     * @param b
     * @param m m<=size(a+b)
     * @return
     */
    private static int findM(int[] a, int[] b, int m) {
        int la = a.length;
        int lb = b.length;
        int counter = 0;
        int t1 = 0, t2 = 0;
        int result;
        while (true) {
            if (t1 == la) {
                result = b[t2];
                t2++;
            } else if (t2 == lb) {
                result = a[t1];
                t1++;
            } else if (a[t1] <= b[t2]) {
                result = a[t1];
                t1++;
            } else {
                result = b[t2];
                t2++;
            }
            counter++;
            if (counter == m) break;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 5, 6}, new int[]{2, 7, 9, 10}));
    }
}
