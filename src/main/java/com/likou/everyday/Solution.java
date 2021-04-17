package com.likou.everyday;


import java.util.*;

public class Solution {

    public static int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        while (fast < n) {
            nums[slow++] = nums[fast++];
            while (fast >= 1 && fast < n && nums[fast] == nums[fast-1]) {
                fast++;
            }
        }
        // slow = 1;
        // fast = 1;
        // while (fast < n) {
        //     if (nums[slow - 1] != nums[fast]) {
        //         nums[slow] = nums[fast];
        //         slow++;
        //     }
        //     fast++;
        // }
        return slow;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,5,9,9});
    }
}





