package com.likou.everyday;


import java.util.Arrays;

public class Solution {

    public static int findMin_1(int[] nums) {
        int low = 0, height = nums.length - 1;
        while (low < height) {
            //最小值在该范围, 且范围内数字是递增
            if (nums[low] <= nums[height]) {
                return nums[low];
            }
            int mid = low + ((height - low) >> 1);
            //最小值在该范围, 且范围内数字是递减
            if (nums[low] >= nums[mid] && nums[mid] >= nums[height]) {
                return nums[height];
            }
            if (nums[mid] < nums[height]) {
                height = mid;
            } else {
                low = mid;
            }
        }
        return nums[low];
    }

    public static int findMin(int[] nums) {
        int low = 0, height = nums.length - 1;
        while (low < height) {
            int mid = low + ((height - low) >> 1);
            if (nums[mid] < nums[height]) {
                //不减1, 避免排除最小值
                height = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,1,2}));
    }
}

