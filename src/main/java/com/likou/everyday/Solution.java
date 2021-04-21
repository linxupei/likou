package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * 设dp[i]表示字符串 s 的前 i 个字符 s[1..i] 的解码方法数
     * 第一种情况: 对s[i]进行单个字符解码, 只要s[i] != 0, 则dp[i] = dp[i-1]
     * 第二种情况: 对s[i-1],s[i]两个字符进行解码, 需要s[i-1] != 0 && s[i-1,i]组合小于'26', 则dp[i] = dp[i-2]
     */
    public static int numDecodings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        //第一个字符为'0', 无法解码
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            //当连续出现两个字符'0'或者连续出现的两个字符大于'20', 说明无法解码
            if (i > 1 &&chars[i - 1] == '0' && (chars[i - 2] == '0' || chars[i - 2] >= '3')) {
                return 0;
            }
            if (chars[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && chars[i - 2] != '0' && ((chars[i-2] - '0') * 10 + chars[i-1] - '0' <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("2611055971756562"));
    }
}





