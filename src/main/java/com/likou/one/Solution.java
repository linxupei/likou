package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 首先把所有字符之间的差值找出来, 依次作为串
     * 然后通过逐渐扩大的滑动窗口, 把符合条件的子串找出来
     * 窗口扩大: total > maxCost(即窗口花费小于最大花费)
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int length = sChars.length;
        int[] differ = new int[length];
        int total = 0;
        int left = 0, right = 0;
        for (int i = 0; i < length; i++) {
            differ[i] = Math.abs(tChars[i] - sChars[i]);
        }
        while (right < length) {
            int temp = differ[right];
            total += temp;
            right++;
            if (total > maxCost) {
                total -= differ[left];
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring(new String("krrgw"), new String("zjxss"), 19));
    }
}

