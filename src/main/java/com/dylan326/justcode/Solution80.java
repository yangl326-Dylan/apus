package com.dylan326.justcode;

public class Solution80 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length <=2){
            return nums.length;
        }
        int result = 2;
        for (int i = 2; i < nums.length ; i++) {
            if(nums[i] != nums[result -2]){
                nums[result++] = nums[i];
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2,2,2,333}));
    }
}
