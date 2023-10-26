package com.dylan326.justcode;

/**
 * Created by dylan on 2023/10/26.
 */
public class C21FruitTree {
    public static int lessDayToGetFruit(int x, int y, int z) {
        int max = z / x + 1;
        int lessDay = 0;
        int result = 0;
        for (int i = 1; i < max; i++) {
            lessDay = i * x + (i % 3 == 0 ? i / 3 : i / 3 + 1) * y;
            if (lessDay >= z) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lessDayToGetFruit(1, 2, 10));
    }
}
