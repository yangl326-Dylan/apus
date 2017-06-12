package com.dylan326.justcode;

/**
 * Created by dylan on 2017/6/6.
 * 字典序下个序列
 * permutation 排列
 */
public class C2DicOrder {

    //{1,2,6,5,4,3,0}
    private static int[] nextOrder(int[] a) {
        int flag = -1;
        int index = 0;
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] > a[i - 1]) {
                flag = a[i - 1];
                index = i - 1;
                break;
            }
        }

        if (flag == -1) {
            return a;
        }

        int delta = Integer.MAX_VALUE;
        int indexSwap = 0;
        for (int i = index + 1; i < a.length; i++) {
            if (a[i] > flag && (a[i] - flag) < delta) {
                delta = (a[i] - flag);
                indexSwap = i;
            }
        }

        swap(a, index, indexSwap);
        sortIncr(a, index + 1, a.length);
        return a;
    }

    private static void sortIncr(int[] a, int j, int length) {
        for (int i = j; i < length; i++) {
            for (int m = i; m < length; m++) {
                if (a[i] > a[m]) {
                    swap(a, i, m);
                }
            }
        }
    }

    private static void swap(int[] a, int index, int indexSwap) {
        int tmp = a[index];
        a[index] = a[indexSwap];
        a[indexSwap] = tmp;
    }

}
