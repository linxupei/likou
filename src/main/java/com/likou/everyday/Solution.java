package com.likou.everyday;


import java.util.Arrays;

public class Solution {

    /**
     * 第一钟使用了判断原数组中是否存在三个以上的相同数字思想
     * 第二种使用了判断更改数组中是否已经存在了两个相同数字思想
     */
    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
//        while (fast < n) {
//            nums[slow++] = nums[fast++];
//            while (fast >= 1 && fast < n - 1 && nums[fast] == nums[fast-1] && nums[fast] == nums[fast+1]) {
//                fast++;
//            }
//        }
        slow = 2;
        fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}

