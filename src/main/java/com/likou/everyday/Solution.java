package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    /**
     * 动态规划
     * dp[i][k] 表示青蛙能否 经过上一次跳跃距离为k 到达编号为i
     * dp[i][k] = dp[j][k-1] || dp[j][k] || dp[j][k+1]
     * 1.结论1
     * 设青蛙目前所在石子编号为i, 上一次跳跃距离为k
     * 青蛙的每次跳跃, 石子编号至少增加1, 跳跃距离至多增加1
     * 在经过m次跳跃之后, i >= m, k <= m
     * 因此 k <= i
     * 2.结论2
     * 由结论1可知, 当第i个石子与第i-1个石子的距离大于i时
     * 青蛙不可达第i个石子, 因为在第i-1个石子上青蛙最多跳出i的距离
     */
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        //设定青蛙所处石子编号为0, 上一次跳跃距离为0
        dp[0][0] = true;
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i-1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canCross1(int[] stones) {
        Boolean[][] rec = new Boolean[stones.length][stones.length];
        return dfs(stones, rec, 0, 0);
    }

    public boolean dfs(int[] stones, Boolean[][] rec, int i, int lastDistance) {
        //已经达到最后一个石子
        if (i == stones.length - 1) {
            return true;
        }
        //已经尝试过 经过跳跃数为lastDistance, 到达编号为i石子 的操作
        if (rec[i][lastDistance] != null) {
            return rec[i][lastDistance];
        }
        for (int currentDistance = lastDistance - 1; currentDistance <= lastDistance + 1; currentDistance++) {
            if (currentDistance > 0) {
                //查找一个以当前结点为坐标经过跳跃数为currentDistance能达到的结点
                int j = Arrays.binarySearch(stones, i + 1, stones.length, stones[i] + currentDistance);
                if (j >= 0 && dfs(stones, rec, j, currentDistance)) {
                    return rec[i][lastDistance] = true;
                }
            }
        }
        return rec[i][lastDistance] = false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canCross(new int[]{0,1,3,5,6,8,12,17});
    }
}





