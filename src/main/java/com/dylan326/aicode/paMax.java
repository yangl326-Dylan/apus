package com.dylan326.aicode;

/**
 * 该类用于解决查找字符串中最长回文子串的问题
 */
public class paMax {

    /**
     * 查找并返回字符串中的最长回文子串
     * @param s 输入的字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 处理奇数长度的回文
            int len2 = expandAroundCenter(s, i, i + 1); // 处理偶数长度的回文
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 以给定的左右索引为中心，向两边扩展，计算回文子串的长度
     * @param s 输入的字符串
     * @param left 左索引
     * @param right 右索引
     * @return 回文子串的长度
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        paMax solution = new paMax();
        String testStr = "babad";
        System.out.println("最长回文子串是: " + solution.longestPalindrome(testStr));
    }
}
