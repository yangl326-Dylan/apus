package com.dylan326.justcode;

/**
 * Created by dylan on 2018/1/22.
 * r[i][j] 表示 i->j为回文串
 * r[i][j] : a[i] == a[j] r[i][j] = r[i+1][j-1]+2
 */
public class C9MaxPalindromeSubStr {

    /**
     *  方法一  动态规划， result[i][j] 表示 i->j为回文串
     *  那么 array[i]=array[j] 并且result[i+1][j-1]为回文串， 那么新结果为长度+2
     * @param str
     * @return
     */
    public static int maxSubStr(String str) {
        char[] array = str.toCharArray();
        if (array.length <= 1) {
            return array.length;

        }
        int size = array.length;
        int[][] result = new int[size][size];
        int max = 1;
        for (int i = size - 1; i >= 0; i--) { // 注意 遍历的方式和初始条件取决于 状态转移方程。需要利用到之前计算出的结果。
            result[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (array[i] == array[j]) {
                    result[i][j] = result[i + 1][j - 1] + 2;
                }
                if (result[i][j] > max) {
                    max = result[i][j];
                    System.out.println(String.format("index,i=%d,j=%d, max=%d", i, j,max));
                }
            }
        }
        return max;
    }

    /**
     *  方法二  源串为strA="abbacac",  反转的串 strB="cacabba" 这个问题等同于源串和反转串的最长公共子串问题
     *  但是需要排除掉某些场景"abc123cba"和"abc321cba",可以最长公共子串,判定最长的逻辑加上是否回文判定就行
     *
     * @param str
     * @return
     */
    public static int maxSubStr2(String str) {
        return 0;
    }


    /**
     *  方法三
     *  实现见 A5LongestPalindromeStr.java
     * @param str
     * @return
     */
    public static int maxSubStr3(String str) {
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(maxSubStr("bbbbbab"));
    }
}
