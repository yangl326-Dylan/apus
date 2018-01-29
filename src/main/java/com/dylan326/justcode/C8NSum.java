package com.dylan326.justcode;

/**
 * Created by dylan on 2017/9/21.
 */
public class C8NSum {
    public static void main(String[] args) {
        nSum(new int[]{1, 0, -1, 0, -2, 2}, 0, 5, 4, 0);
    }

    /**
     *
     * @param a 数组
     * @param i 数组索引起始
     * @param j 数组索引结束
     * @param n 层次
     * @param m 目标值
     */
    public static void nSum(int[] a,int i, int j, int n, int m){

        if(n == 1){
            for (int k = i; k < j+1 ; k++) {
                if(a[k] == m){
                    System.out.println("........done="+a[k]);
                }else{
                    System.out.println("continue");
                }
            }
        }
        if(i == j){
            return;
        }
        for (int k = i; k < j+1 ; k++) {
            System.out.println("pre="+a[k]);
            nSum(a,k+1,j, n-1,m-a[k]);
        }
    }

}
