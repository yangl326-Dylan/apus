package com.dylan326.apus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dylan on 2017/5/22.
 * 待补充其他方案，
 * 1、直接方法
 * 2、nums-target， 判断两数组是否有公共元素
 */
public class A1Sum3 {
    public static List<List<Integer>> a1Sum3Method1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int last = nums[0]-1;
        for (int i = 0; i < nums.length - 2; i++) {
            int c = -1*nums[i];
            if(nums[i] == last) {

                continue;
            }
            last = nums[i];
            int start=i+1,end=nums.length-1;
            while (start < end) {
                int tmp = (nums[start] + nums[end]);
                if (tmp == c) {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[i]);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    result.add(res);
                    start++;
                    end--;
                    while(start<end && nums[start] == nums[start-1])
                    {
                        start++;
                    }
                    while(end>start && nums[end] == nums[end+1])
                    {
                        end--;
                    }

                }
                else if (tmp < c) {
                    start++;
                    while(start<end&&nums[start] == nums[start-1])
                    {
                        start++;
                    }
                }
                else {
                    end--;
                    while(end>start&&nums[end] == nums[end+1])
                    {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println((a1Sum3Method1(new int[]{0,0,0,0}, 0)));
    }
}
