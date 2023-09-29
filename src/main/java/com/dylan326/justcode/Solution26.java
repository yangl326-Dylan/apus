package com.dylan326.justcode;

public class Solution26 {
    public static int removeDuplicates(int[] nums) {
        int firstIndex = 0;
        int currentNum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            if(nums[firstIndex] == currentNum){
                continue;
            }else{
                nums[firstIndex +1]  = nums[i];
                firstIndex ++;
            }
        }
        return  firstIndex+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,333,333}));
    }
}
