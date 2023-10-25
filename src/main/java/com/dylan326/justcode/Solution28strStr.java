package com.dylan326.justcode;

/**
 * Created by dylan on 2023/10/25.
 */
public class Solution28strStr {
    /**
     * 找出 needle 在 haystack 的第一个下标
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("12345","23"));
        System.out.println(strStr("12345","456"));
        System.out.println(strStr("12","123"));
    }
}
