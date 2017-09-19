package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 方法一：有点不合理， 找了所有子串。*
 * 方法二：最长为源串长度n， 逐步按照n-- 来查找回文串， 第一个跳出
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

        for (int i = 0; i < array.length; i++) {
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
        for (int i = 0; i < array.length - 1; i++) {
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
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s == null) {
            return null;
        }
        int[][] tmpResult = new int[s.length()][s.length()];
        char[] tmp = s.toCharArray();
        int max=0,start =0;
        for (int i = 0; i < tmp.length; i++) {
            tmpResult[i][i] = 1;
            if(max <1){
                max =1;
                start=i;
            }
            if (i < tmp.length - 1 && tmp[i] == tmp[i + 1]) {
                tmpResult[i][i+1] = 1;
                if(max <2 ){
                    start =i;
                    max =2;
                }

            }
        }

        for (int i = 2; i <=s.length(); i++) {
            for (int j = 0; j <s.length()+1-i; j++) {
                int end = j+i-1;
                if (tmp[j] == tmp[end] && tmpResult[j + 1][end - 1] == 1) {
                    tmpResult[j][end] = 1;
                    if (end - j + 1 > max) {
                        max = end - j + 1;
                        start = j;
                    }
                }

            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        A5LongestPalindromeStr a5 = new A5LongestPalindromeStr();
        System.out.println(a5.longestPalindrome3(""));
    }
}
