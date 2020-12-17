package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * 由于转移过程之与前一个相关, 因此也可以只采用两个变量保存状态
     */
    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int [][]dp = new int[length][2];
        //dp[i][0]用于保存第i天没有股票的最大利润
        //dp[i][1]用于保存第i天持有股票的最大利润
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i] - fee);
        }
        return dp[length-1][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}

