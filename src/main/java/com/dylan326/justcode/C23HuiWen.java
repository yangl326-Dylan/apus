package com.dylan326.justcode;

public class C23HuiWen {
    public boolean isP(String str) {
        int[] a = new int[128];
        for (int i = 0; i < str.toCharArray().length; i++) {
            a[str.charAt(i)] += 1;
        }
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0 || a[i] % 2 == 0) {
                continue;
            }
            if (a[i] % 2 != 0) {
                counter++;
                if (counter > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
