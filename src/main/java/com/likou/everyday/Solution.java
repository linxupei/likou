package com.likou.everyday;


import java.util.Arrays;

public class Solution {

    public static boolean search(int[] nums, int target) {
        int low = 0, height = nums.length - 1;
        while (low <= height) {
            int mid = low + ((height - low) >> 1);
            if (nums[mid] == target) {
                return true;
            } else if (nums[low] == nums[mid] && nums[mid] == nums[height]) {
                //遇到类似情况[1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1], 2
                low++;
                height--;
            } else if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    height = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[height]) {
                    low = mid + 1;
                } else {
                    height = mid - 1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
    }
}

