package com.dylan326.apus;

import java.util.List;

/**
 * Created by dylan on 2017/9/21.
 * 数据x轴间隔固定是1，最两边的构成一个矩形，为初始面积， 比他大的只可能是短边被替换，因为delta X变小，如果出现面积更大，只可能是比短边更长的边，
 *
 */
public class A11MostContainer {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            int minHeight = height[left] < height[right] ? height[left] : height[right];
            int curr = (right - left) * minHeight;
            max = max > curr ? max : curr;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


    public static void main(String[] args) {

    }
}
