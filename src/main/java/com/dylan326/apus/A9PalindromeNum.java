package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 数字是否是回文，如下两种方法
 * 1、直接方法
 * 2、翻转数字，和源数字判定是否相等。 注意翻转可能会出现int越界
 */
public class A9PalindromeNum {
    public static boolean isPalindrome1(int x) {
        if(x == Integer.MAX_VALUE || x== Integer.MIN_VALUE){
            return false;
        }
        if (x < 0) {
            return false;
        }
        int tmp = x;
        int l = 0;
        while ((tmp = tmp / 10) != 0) {
            l++;
        }
        int i = 0;
        while (i < (l+1) / 2) {
//            System.out.println(i + ":" + (l - i));
            if (getMold(x, i) == getMold(x, l - i)) {
                i++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int getMold(int x, int n) {
        int result = 1;
        while (n> 0) {
            result = result * 10;
            n--;

        }
        return (x/result)%10;
    }

//    public static boolean isPalindromeNum2(int x) {
//
//    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(13331));
    }
}
