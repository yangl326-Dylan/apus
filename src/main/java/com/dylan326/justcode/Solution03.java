package com.dylan326.justcode;

public class Solution03 {
    public static int lengthOfLongestSubstring(String s) {
        char[] sArray = s.toCharArray();
        if (sArray.length == 0) return 0;
        int result = 1;
        for (int i = 0; i < sArray.length; i++) {
            for (int j = i + 1; j < sArray.length; j++) {
                if (contain(sArray, i, j, sArray[j])) {
                    break;
                }
                if (j - i +1 > result) {
                    result = j - i + 1;
                }
            }
        }
        return result;
    }

    private static boolean contain(char[] a, int start, int end, char target) {
        for (int i = start; i < end; i++) {
            if (a[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("hahahaadfw"));
    }
}
