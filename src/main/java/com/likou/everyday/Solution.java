package com.likou.everyday;


import java.util.Arrays;

public class Solution {


    public static int findMin(int[] nums) {
        int low = 0, height = nums.length - 1;
        while (low < height) {
            int mid = low + ((height - low) >> 1);
            if (nums[mid] == nums[low] && nums[mid] == nums[height]) {
                //三个位置都相等时无法判断是否还有更小值, 先把左右两个相等的去掉
                low++;
                height--;
            } else if (nums[mid] <= nums[height]) {
                //不减1, 避免排除最小值
                height = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,2,2,2,2,2,2,2,2,2,2,1,2,2}));
    }
}

