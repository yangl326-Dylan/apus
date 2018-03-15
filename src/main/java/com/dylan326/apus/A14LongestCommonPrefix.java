package com.dylan326.apus;

/**
 * Created by dylan on 2018/3/15.
 * 没想其他的 考虑好边界条件和处理逻辑
 */
public class A14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        if (strs[0].length() == 0) {
            return "";
        }
        a:
        while (true) {
            char tmp;
            for (int i = 0; i < strs.length; i++) {
                if (index > strs[i].length() - 1) {
                    break a;
                }
                tmp = strs[0].charAt(index);
                if (tmp != strs[i].charAt(index)) {
                    break a;
                }
            }
            index++;
        }
        if (index == 0) {
            return "";
        } else {
            return strs[0].substring(0, index);
        }
    }

    public static void main(String[] args) {
        A14LongestCommonPrefix a14LongestCommonPrefix = new A14LongestCommonPrefix();
        System.out.println(a14LongestCommonPrefix.longestCommonPrefix(new String[]{"1"}));
    }
}
