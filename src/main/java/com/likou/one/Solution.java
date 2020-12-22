package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {

    /**
     * ���ڵ����i��ɴ�i-1���i-2�㿪ʼ
     * ��������dp[n+1]
     * dp[0],dp[1]��ʾ��һ�ڶ���
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < n+1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }


    public static void main(String[] args) {

    }
}

