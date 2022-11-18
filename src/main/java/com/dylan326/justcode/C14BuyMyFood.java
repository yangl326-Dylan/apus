package com.dylan326.justcode;

/**
 * Created by dylan on 2022/11/11.
 * 到周末了，小周为了犒劳辛苦了一周得自己，打算去超市买点自己喜欢的零食吃。由于各个超市的备货情况不同，小周可能需要多走几个超市才能买完自己想要的零食。小周有 n 种心仪的零食，小区附近有 m 家超市，第 i 家超市售卖 ct_i 种零食，分别为第 ai,1 , ai,2 , ... , ai,ct_i  种，小周想要知道至少要需要访问几家超市，才能买齐这 n 种零食？
 * <p>
 * 5 4 （n，m）
 * 1 2  第一家有1，2
 * 3 1 3 5
 * 2 2 4
 * 1 4
 * 输出 2  找不到输出-1
 */
public class C14BuyMyFood {
    public static int buyMyFood(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[] result = new int[n];
        int counter = m + 1;
        int startM = 0;
        for (int i = startM; i < m; ) {
            for (int j = 0; j < n; j++) {
                if(input[i][j]  == 0){
                    break;
                }
                result[input[i][j] - 1] = 1;
                if (checkResult(result)) {
                    counter = (counter > (i - startM + 1) ? (i - startM + 1) : counter);
                    System.out.println("startIndex" + startM + ", marketIndex:" + i);
                    System.out.println("-------");
                    for (int k = 0; k < result.length; k++) { // reset result
                        result[k] = 0;
                    }
                    i = startM ;
                    startM = i +1;
                    break;
                }
            }
            i++;

        }

        return counter == m + 1 ? -1 : counter;
    }

    private static boolean checkResult(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nm = new int[][]{{1, 2, 0, 0, 0}, {3, 1, 3, 5, 0}, {2, 2, 4, 0, 0,}, {1, 2, 3, 4, 5}}; // 换成输入
        System.out.println(buyMyFood(nm));

    }
}
