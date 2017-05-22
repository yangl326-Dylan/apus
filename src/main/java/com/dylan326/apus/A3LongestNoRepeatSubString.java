package com.dylan326.apus;

/**
 * Created by dylan on 2017/5/22.
 * TODO： 三层性能太差了
 */
public class A3LongestNoRepeatSubString {
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
                        result = (j - i) > result ? (j - i) : result;
                        break t;
                    }
                }
            }
            result = (j - i) > result ? (j - i) : result;
            i++;
            if (result >= (s.length() - i)) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(a3LongestNoRepeatSubString("hiimamaboy"));
    }
}
