package com.dylan326.apus;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dylan on 2017/5/22.
 */
public class A3LongestNoRepeatSubString {
    /**
     * 暴力方法
     *
     * @param s
     * @return
     */
    public static int a3LongestNoRepeatSubString(String s) {
        int result = 0;
        if (s == null) {
            return result;
        }
        int i = 0, j;
        while (true) {
            if (i == s.length()) {
                break;
            }
            t:
            for (j = i; j < s.length(); j++) {
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        result = Math.max((j - i), result);
                        break t;
                    }
                }
            }
            result = Math.max((j - i), result);
            i++;
            if (result >= (s.length() - i)) {
                break;
            }
        }
        return result;
    }

    public static int a3LongestNoRepeatSubString2(String s) {
        char[] tmpChar = s.toCharArray();
        int result = 1;
        for (int i = 0; i < tmpChar.length; i++) {
            for (int j = i + 1; j < tmpChar.length; j++) {
                if (s.substring(i, j).contains(String.valueOf(tmpChar[j]))) {
                    break;
                } else {
                    result = Math.max(j - i + 1, result);
                }
            }
        }
        return result;
    }

    /**
     * 滑动窗口 实际是双指针
     *
     * @param s
     * @return
     */
    public static int a3LongestNoRepeatSubString3(String s) {
        int n = s.length();
        Set set = new HashSet();
        int maxSize = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxSize = Math.max(maxSize, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxSize;
    }


    public static void main(String[] args) {
        System.out.println(a3LongestNoRepeatSubString("hiimapmaboy"));
        System.out.println(a3LongestNoRepeatSubString2("hiimapmaboy"));
        System.out.println(a3LongestNoRepeatSubString3("hiimapmaboy"));
    }
}
