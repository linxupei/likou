package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    /**
     * 放缩边界
     */
    public boolean judgeSquareSum1(int c) {
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    /**
     * x*x + y*y = c
     * 使用sqrt(c - x*x)函数判断是否为整数即可
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int)b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}





