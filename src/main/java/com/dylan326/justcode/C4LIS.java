package com.dylan326.justcode;

/**
 * Created by dylan on 2017/6/13.
 */
public class C4LIS {
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

    public static void main(String[] args) {
        System.out.println(LIS(new int[]{1,3,2,5,7,4,10}));
    }
}
