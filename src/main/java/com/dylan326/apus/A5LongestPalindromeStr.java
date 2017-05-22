package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * 有点不合理， 找了所有子串
 */
public class A5LongestPalindromeStr {
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

}
