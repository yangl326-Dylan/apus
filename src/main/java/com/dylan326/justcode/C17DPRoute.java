package com.dylan326.justcode;

/**
 * Created by dylan on 2023/3/13.
 * 最优路径，一个二维格子，初始在左上角，只能向右、向下移动，移动前判定金币余额，可以任意格子退出游戏。 每次所剩金币必须>0。最多获得的金币数是多少
 *
 * 第一行是三个用空格隔开的整数n、m和k，表示网格地图的行数为n，列数为m，在不同颜色的两个格子间移动需要支付k个金币。
 * 接下来n行，每行是一个长度为m的字符串，字符串仅包含字符’R’或’B’。第 i 行字符串的第 j 个字符表示地图上第i行第j列的格子颜色，如果字符为’R’则表示格子颜色为红色，为’B’表示格子颜色为蓝色。
 * 接下来是一个n行m列的非负整数矩阵，第 i 行第 j 列的数字表示地图上第 i 行第 j 列的格子上的金币数量。保证所有数据中数字大小都是介于[0, 10]的整数。1<=n,m<=200, 1<=k<=5。
 *
 * 典型的动态规划问题，三段式：初始化边界结果值 + 写出状态转移方程 + 找出结果
 */
public class C17DPRoute {

    /**
     * 结果集找到最大值
     *
     * @param n
     * @param m
     * @param tmp
     * @return
     */
    private static int findMaxInArray(int n, int m, int[][] tmp) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(tmp[i][j] + " ");
                if (tmp[i][j] > result) {
                    result = tmp[i][j];
                }
            }
            System.out.print("\n");
        }
        return result;
    }

    public static int maxCoinForBestRoute(int n, int m, int k, char[][] colors, int[][] coins) {
        int[][] result = new int[n][m];
        result[0][0] = 0;
        for (int i = 1; i < n; i++) { // 初始化 result[i][0]
            if (colors[i][0] == colors[i - 1][0]) {
                result[i][0] = result[i - 1][0] + coins[i][0];
            } else {
                if (result[i][0] - k < 0) {
                    break;
                }
                result[i][0] = result[i - 1][0] - k + coins[i][0];
            }

        }

        for (int j = 1; j < m; j++) { // 初始化 result[0]【j]
            if (colors[0][j] == colors[0][j - 1]) {
                result[0][j] = result[0][j - 1] + coins[0][j];
            } else {
                if (result[0][j] - k < 0) {
                    break;
                }
                result[0][j] = result[0][j - 1] - k + coins[0][j];
            }

        }


        for (int i = 0; i < n; i++) {

            for (int j = 1; j < m; j++) {
                if (colors[i][j] == colors[i][j - 1]) {
                    result[i][j] = result[i][j - 1] + coins[i][j];
                } else {
                    if (result[i][j - 1] - k < 0) {
                        continue;
                    }
                    result[i][j] = result[i][j - 1] - k + coins[i][j];
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (colors[i][j] == colors[i - 1][j]) {
                    result[i][j] = result[i - 1][j] + coins[i][j];
                } else {
                    if (result[i - 1][j] - k < 0) {
                        continue;
                    }
                    result[i][j] = result[i - 1][j] - k + coins[i][j];
                }
            }
        }


        return findMaxInArray(n, m, result);
    }

    public static void main(String[] args) {
        // input
        int n = 1;
        int m = 7;
        int k = 2;
        char[][] colors = {{'B', 'B', 'R', 'B', 'R', 'B', 'R'}};
        int[][] coins = {{0, 3, 2, 4, 1, 1, 1}};
        System.out.println(maxCoinForBestRoute(n, m, k, colors, coins));
    }
}
