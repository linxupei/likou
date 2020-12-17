package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length == 1 || prices.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int temp = prices[i+1] - prices[i] - fee;
            if (temp > 0) {
                total += temp;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}

