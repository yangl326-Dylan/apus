package com.dylan326.justcode;

/**
 * Created by zhou on 2017/6/23.
 * n阶台阶走法问题
 * 条件：可以一步1个台阶、2个台阶、3个台阶
 * 递归思路
 * n=1
 * n=2
 * n=3 递归函数出口条件
 * 如何归纳出递归函数：
 * 最后剩1个台阶，那么前n-1个的走法是f（n-1）
 * 最后剩2个台阶，那么前n-1个的走法是f（n-2）
 * 最后剩3个台阶，那么前n-1个的走法是f（n-3）
 * 那么n的走法就是上述的走法之和
 */
public class C5nTJ {

    /**
     * n个台阶的走法问题
     *
     * @param n
     * @return
     */
    public static int nTJ(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (n > 3) {
            return nTJ(n - 1) + nTJ(n - 2) + nTJ(n - 3);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(nTJ(5));
    }
}
