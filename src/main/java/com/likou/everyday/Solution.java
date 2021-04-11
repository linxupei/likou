package com.likou.everyday;


import lombok.extern.java.Log;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.regex.Matcher;

public class Solution {

    /**
     * 先排后找
     * 丑数: n = 2^(a) * 3^(b) * 5^(c)
     * a,b,c代表dp中相应下标的丑数乘以2,3,5的资格
     */
    public static int nthUglyNumber1(int n) {
        int flag = 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        while (flag <= n) {
            int numa = dp[a] * 2;
            int numb = dp[b] * 3;
            int numc = dp[c] * 5;
            dp[flag] = Math.min(Math.min(numa, numb), numc);
            if (dp[flag] == numa) {
                a++;
            }
            if (dp[flag] == numb) {
                b++;
            }
            if (dp[flag] == numc) {
                c++;
            }
            flag++;
        }
        return dp[flag - 1];
    }

    /**
     * 先找后排
     * 丑数: n = 2^(a) * 3^(b) * 5^(c)
     * 小根堆+hashset
     */
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> small = new PriorityQueue<>();
        HashSet<Long> hashSet = new HashSet<>();
        small.add(1L);
        hashSet.add(1L);
        for (int i = 0; i < n - 1; i++) {
            Long poll = small.poll();
            if (!hashSet.contains(poll * 2)) {
                hashSet.add(poll * 2);
                small.add(poll * 2);
            }
            if (!hashSet.contains(poll * 3)) {
                hashSet.add(poll * 3);
                small.add(poll * 3);
            }
            if (!hashSet.contains(poll * 5)) {
                hashSet.add(poll * 5);
                small.add(poll * 5);
            }
        }
        return (int)(long)small.poll();
    }


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}

