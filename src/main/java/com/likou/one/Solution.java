package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 通过不断增长的滑动窗口原理, 每次遇到非1
     * 即打破窗口, 统计窗口长度
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int max = 0;
        for (int num : nums) {
            if (num != 1) {
                max = Math.max(max, right - left);
                left = right + 1;
            }
            right++;
        }
        return Math.max(max, right - left);
    }


    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1}));
    }
}

