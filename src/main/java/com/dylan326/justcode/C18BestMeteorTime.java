package com.dylan326.justcode;

/**
 * Created by dylan on 2023/3/14.
 * 观察流星最多的时刻
 * 输入
 * 第一行是一个正整数n，表示流星的数量。
 * 第二行是n个用空格隔开的正整数，第i个数si表示第i个流星的出现时间。
 * 第三行是n个用空格隔开的正整数，第i个数ti表示第i个流星的消失时间。
 * 1<=n<=100000, 1<=si<=ti<=10^9
 * 输出一行用空格隔开的两个数x和y，其中x表示能观测到的最多流星数，y表示可供她选择的最佳时刻数量。
 */
public class C18BestMeteorTime {
    /**
     *  找到两个元组 交集的整数集合
     * 这个思路废弃
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    @Deprecated
    private static int[] innerNum(int x1, int x2, int y1, int y2) {
        if (x2 < y1 || y2 < x1) {
            return new int[]{};
        }
        int a = (x1 <= y1 ? y1 : x1);
        int b = (x2 >= y2 ? y2 : x2);
        int[] result = new int[b - a + 1];
        for (int i = 0; i < b - a + 1; i++) {
            result[i] = a + i;
        }
        return result;
    }

    public static void printBestTimeForMeteor(int n, int[] si, int[] ti) {
        int minSi = Integer.MAX_VALUE;
        int maxTi = 0;
        for (int i = 0; i < si.length; i++) {
            if (si[i] < minSi) {
                minSi = si[i];
            }
        }
        for (int i = 0; i < ti.length; i++) {
            if (ti[i] > maxTi) {
                maxTi = ti[i];
            }
        }
        int[] result = new int[maxTi]; // 初始化结果集，空间换时间， 也可以用hashmap存储结果

        for (int i = 0; i < n; i++) {
            for (int j = si[i] -1 ; j < ti[i]; j++) {
                result[j] = result[j] + 1;
            }
        }
        int maxMetetor = 0;
        int counter = 0;
        for (int i = 0; i < result.length; i++) { // 找出题目结果
            if (result[i] > maxMetetor) {
                maxMetetor = result[i];
                counter = 1;
            } else if (result[i] == maxMetetor) {
                counter++;
            }

        }
        System.out.println(maxMetetor + " " + counter);
    }

    public static void main(String[] args) {
        int n = 3;
        int[] si = {2, 1, 5};
        int[] ti = {6, 3, 7};
        printBestTimeForMeteor(n, si, ti);
        printBestTimeForMeteor(1, new int[]{2}, new int[]{6});
    }
}
