package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * ����ת�ƹ���֮��ǰһ�����, ���Ҳ����ֻ����������������״̬
     */
    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int [][]dp = new int[length][2];
        //dp[i][0]���ڱ����i��û�й�Ʊ���������
        //dp[i][1]���ڱ����i����й�Ʊ���������
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

