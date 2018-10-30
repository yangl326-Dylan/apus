package com.dylan326.apus;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 分析 ：直接方案是遍历数组 遇到和val相同的元素 与后面不和val相同的元素交换
 * 此处小技巧， 后面不同于val的元素可以按照倒序来交换
 * 实现相对较OK  优于99.85%的提交
 */
public class A27RemoveElement {

    public int removeElement(int[] nums, int val) {
        int counter = 0;
        int end = nums.length - 1; // end标记需要交换的元素
        for (int i = 0; i < nums.length; i++) {
            if(i > end) break;
            if(nums[i] == val){
                while (nums[end]==val){// 从尾部向前找 第一个不等于val的元素
                    end--;
                    if(end <i){ // 全部是val的情况会导致end < 此时i的值， 返回统计计数
                        return counter;
                    }
                }
                int tmp = nums[i]; // 交换i和end元素位置
                nums[i] = nums[end];
                nums[end] = tmp;
                end--;
                counter++; // 和不同于val的元素交换后需要计数++
            } else {
                counter++; // 不同于val的元素 计数++
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        A27RemoveElement a= new A27RemoveElement();
        a.removeElement(new int[]{4,5},5);

    }
}
