package com.dylan326.apus;

/**
 * Created by dylan on 2017/9/21.
 * 两个边的构成一个矩形，为初始面积， 比他大的只可能是短边被替换，因为delta X变小，如果出现面积更大，只可能是比短边更长的边
 */
public class A11MostContainer {
    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * 给定n个非负整数a1, a2, ..., an，其中每个代表坐标(i, ai)处的一个点。
     * 绘制n条垂直线，使得线i的两个端点位于(i, ai)和(i, 0)。
     * 找出两条线，它们与x轴一起形成一个容器，以便该容器包含最多的水。
     *
     * @param height An array of non-negative integers. / 非负整数数组
     * @return The maximum area of water the container can contain. / 容器可以容纳的最大水量
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            // Find the shorter line / 找到较短的线
            int minHeight = height[left] < height[right] ? height[left] : height[right];
            // Calculate the current area / 计算当前面积
            int curr = (right - left) * minHeight;
            // Update the maximum area / 更新最大面积
            max = max > curr ? max : curr;
            // The logic is that only when the shorter line changes can a larger area appear. / 只有当较短的线改变时，才可能出现更大的面积
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        A11MostContainer a11MostContainer = new A11MostContainer();
        System.out.println(a11MostContainer.maxArea(new int[]{1, 6, 3, 4}));
    }
}
