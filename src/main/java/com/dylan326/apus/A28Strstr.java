package com.dylan326.apus;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 */
public class A28Strstr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) { // 这是个啥边界
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int tmp = i;
            if (haystack.length() - tmp < needle.length()) {
                return -1;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(tmp++) == needle.charAt(j)) {
                    if (j == needle.length() - 1) {
                        return i;
                    } else {
                        continue;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        A28Strstr a = new A28Strstr();
        System.out.println(a.strStr("0", "0"));
    }
}
