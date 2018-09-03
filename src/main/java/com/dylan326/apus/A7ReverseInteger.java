package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 翻转整数和翻转数据串可以用不一样的思路， 因为整数的特性
 */
public class A7ReverseInteger {
    public int reverse(int x) {
        long i = 0; // 注意整数反转可能越界
        while (x != 0) {
            i = i * 10 + x % 10; // 末尾进位
            x = x / 10; //移除掉末尾
        }
        if (i > Integer.MAX_VALUE || i < Integer.MIN_VALUE) {
            i = 0;
        }
        return (int) i;
    }
}
