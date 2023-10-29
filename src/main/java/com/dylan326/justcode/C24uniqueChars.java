package com.dylan326.justcode;

public class C24uniqueChars {

    public static boolean isUniqueChar(String str) {
        int[] check = new int[128];
        for (int i = 0; i < str.length(); i++) {
            check[str.charAt(i)] += 1;
            if (check[str.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUniqueChar("abcv"));
    }
}
