package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 翻转整数和翻转数据串可以用不一样的思路， 因为整数的特性
 */
public class A7ReverseInteger {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }
}
