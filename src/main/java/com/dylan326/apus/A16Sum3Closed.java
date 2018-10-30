package com.dylan326.apus;

import java.util.Arrays;

/**
 * Created by dylan on 2017/9/21.
 * TODO 写的太垃圾了
 */
public class A16Sum3Closed {
    /**
     * 效率太差
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3){
            return nums[0]+nums[1]+nums[2];
        }
        int delta = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int tmp = target -nums[i]-nums[j]-nums[k];
                    if(tmp >=0 && tmp <=delta){
                        delta = tmp;
                        sum = target-tmp;
                    }
                    if(tmp <0 && -tmp <delta){
                        delta = -tmp;
                        sum = target-tmp;
                    }
                }
            }
        }
        return sum;
    }

    /**
     * 直接
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        if(nums.length == 3){
            return nums[0]+nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {

        }
        return sum;
    }
    public static void main(String[] args) {
        A16Sum3Closed a = new A16Sum3Closed();
        System.out.println(a.threeSumClosest( new int[]{-1, 2, 1, -4},1));
    }
}