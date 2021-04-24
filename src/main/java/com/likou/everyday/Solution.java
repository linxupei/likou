package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * dp[i]表示nums中选取元素能组成i的组合个数有多少
     * dp[0] = 1, 组成0的只有1钟方式, 表示不选取任何元素
     * dp[i] += dp[i - num], 表示任何一个num(num <= i), 都能加入(i - num)的组合中
     * 使得(i - num) + num = i, 成为新的组合
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    //超出内存限制
    public static int findSum4(int[] nums, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(target);
        int count = 0;
        while (!queue.isEmpty()) {
            Integer pop = queue.pop();
            for (int i = 0; i < nums.length; i++) {
                int temp = pop - nums[i];
                if (temp <= 0) {
                    if (temp == 0) {
                        count += 1;
                    }
                } else {
                    queue.add(temp);
                }
            }
        }
        return count;
    }

    /**
     * 递归找出所有组合, 超时
     */
    public static int findSum(int[] nums, int target) {
        //因为只有正数, 当总和超过target, 无法完成
        if (target < 0) {
            return 0;
        }
        //刚好达成目标返回即可
        if (target == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += findSum(nums, target - nums[i]);
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{2,1,3},35));
    }
}





