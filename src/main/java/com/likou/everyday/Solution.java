package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * 可以仅使用两个变量保存结果
     *
     * dp[i]表示小偷经过第i间房子是可以偷到的最小金额
     * dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
     * 对于每一间房子的金额可以不偷, 也可以在前一间房子没被偷的情况下偷
     *
     */
    public static int robI(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[length];
    }

    /**
     * 第一间房子和最后一间房子不能同时偷窃
     * 因此比较偷[0, n-1]和[1,n]的取值即可
     */
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robI(Arrays.copyOfRange(nums,0,length-1)), robI(Arrays.copyOfRange(nums,1,length)));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,3,1,3,100}));
    }
}




