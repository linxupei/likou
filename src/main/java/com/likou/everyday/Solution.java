package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    /**
     * 统计每一个数字出现的频率 + 对数字进行排序 + 动态规划
     * dp[i]代表来到这个数字的时候能获得的最大值
     * dp[i] =
     **/
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] acount = new int[max + 1];
        for (int i : nums) {
            acount[i]++;
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = acount[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + acount[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 2}));
    }
}





