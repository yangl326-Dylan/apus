package com.dylan326.justcode;

public class Solution169 {
    public static int majorityElement(int[] nums) {
        int num = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == num){
                counter ++;
            }else{
                counter --;
            }
            if(counter == 0){
                num = nums[i+1];
                i++;
                counter = 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
