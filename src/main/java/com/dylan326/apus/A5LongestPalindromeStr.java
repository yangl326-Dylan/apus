package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 方法一：有点不合理， 找了所有子串。
 */
public class A5LongestPalindromeStr {

    /**
     * 找所有， 中分方式
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) return null;
        if (s.length() == 1) return s;
        char[] array = s.toCharArray();
        if (s.length() == 2) {
            if (array[0] == array[1]) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        int start;
        int end;
        int max = 0;
        int result1 = 0;
        int result2 = 0;

        for (int i = 0; i < array.length; i++) {// 奇数情况
            start = i;
            end = i;
            while (start >= 0 && end < array.length) {
                if (array[start] == array[end]) {
                    if ((end - start + 1) > max) {
                        result1 = start;
                        result2 = end;
                        max = end - start + 1;
                    }
                    start--;
                    end++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < array.length - 1; i++) {//偶数情况
            start = i;
            end = i + 1;
            while (start >= 0 && end < array.length) {
                if (array[start] == array[end]) {
                    if ((end - start + 1) > max) {
                        result1 = start;
                        result2 = end;
                        max = end - start + 1;
                    }
                    start--;
                    end++;
                } else {
                    break;
                }
            }
        }
        return s.substring(result1, result2 + 1);
    }

    /**
     * 回文判定
     * 动态规划方案
     * 1、长度为l的字符串s，最长回文子串长度的中间结果可以放在int[l]集合里面
     * 2、name最长回文的最大长度为l， 最小为1或者2. 即初始结果
     *
     * @param s
     * @return 找出回文串
     */
    public String longestPalindrome3(String s) {
        if (s == null) {
            return null;
        }
        int[][] tmpResult = new int[s.length()][s.length()];
        char[] tmp = s.toCharArray();
        int max = 0, start = 0;
        for (int i = 0; i < tmp.length; i++) { //初始化 值为1 或者2的结果。 此结果是延伸结果的前提结果集
            tmpResult[i][i] = 1;
            if (max < 1) {
                max = 1;
                start = i;
            }
            if (i < tmp.length - 1 && tmp[i] == tmp[i + 1]) {
                tmpResult[i][i + 1] = 1;
                if (max < 2) {
                    start = i;
                    max = 2;
                }

            }
        }

        for (int huiwenLength = 2; huiwenLength <= s.length(); huiwenLength++) {
            for (int begin = 0; begin < s.length() + 1 - huiwenLength; begin++) {
                int end = begin + huiwenLength - 1;
                if (tmp[begin] == tmp[end] && tmpResult[begin + 1][end - 1] == 1) {
                    tmpResult[begin][end] = 1;
                    if (end - begin + 1 > max) {
                        max = end - begin + 1;
                        start = begin;
                    }
                }

            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        A5LongestPalindromeStr a5 = new A5LongestPalindromeStr();
        System.out.println(a5.longestPalindrome3("abbacac"));
    }
}
