package com.likou.everyday;


import java.util.Arrays;

public class Solution {

    public static int findMin_1(int[] nums) {
        int low = 0, height = nums.length - 1;
        while (low < height) {
            //��Сֵ�ڸ÷�Χ, �ҷ�Χ�������ǵ���
            if (nums[low] <= nums[height]) {
                return nums[low];
            }
            int mid = low + ((height - low) >> 1);
            //��Сֵ�ڸ÷�Χ, �ҷ�Χ�������ǵݼ�
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
                //����1, �����ų���Сֵ
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

