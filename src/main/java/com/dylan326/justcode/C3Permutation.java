package com.dylan326.justcode;

import java.util.Arrays;

/**
 * Created by dylan on 2017/6/12.
 * 全排列采用字典序方式
 */
public class C3Permutation {
    //    {1,2,3,4}
    public static void permutation(int[] array) {
        int[] tmp = new int[array.length];
        while (!isEqual(tmp,array)){ // 数组不相等，条件依赖字典序下个序列函数写法
            for (int i = 0; i <array.length; i++) {
                tmp[i] = array[i];
            }
            System.out.println(Arrays.toString(tmp));
            C2DicOrder.nextOrder(array);

        }
    }

    private static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        permutation(new int[]{1, 2, 3, 4});
    }
}
