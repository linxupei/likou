package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 运用滑动窗口的原理
     * [left,right]表示符合要求的窗口的范围
     * flag表示上两个数字的比较
     * flag = 1, 表示上两个数字的关系为大于
     * flag = 0, 表示上两个数字的关系为等于
     * flag = -1, 表示上两个数字的关系为小于
     * 当满足湍流数组的要求时, right右移一位
     * 不满足时, 比较(max, right-left+1), 并right右移一位, 然后将right赋值给left,
     * 重新开始计算窗口长度
     */
    public static int maxTurbulenceSize_(int[] arr) {
        int max = 0;
        int flag = 0;
        int left = 0, right = 0;
        int length = arr.length;
        if (length <= 1) {
            return length;
        }
        while (right < length - 1) {
            if (arr[right] > arr[right+1] && (flag < 0 || right == 0)) {
                right++;
                flag = 1;
            } else if (arr[right] < arr[right+1] && (flag > 0 || right == 0)) {
                right++;
                flag = -1;
            } else {
                max = Math.max(max, right - left + 1);
                while (right < length-1 && arr[right] == arr[right+1]) {
                    right++;
                }
                if (right < length-1 && arr[right] > arr[right+1]) {
                    flag = -1;
                } else {
                    flag = 1;
                }
                left = right;
            }

        }
        return Math.max(max, right - left + 1);
    }

    public static int maxTurbulenceSize(int[] arr) {
        int max = 0;
        boolean flag = true;
        int left = 0, right = 0;
        int length = arr.length;
        if (length <= 1) {
            return length;
        }
        while (right < length - 1) {
            if (flag) {
                right++;
                flag = false;
            } else if (arr[right-1] > arr[right] && arr[right] < arr[right+1]) {
                right++;
            } else if (arr[right-1] < arr[right] && arr[right] > arr[right+1]) {
                right++;
            } else {
                max = Math.max(max, right-left+1);
                while (right < length-1 && arr[right] == arr[right+1]) {
                    right++;
                }
                flag = true;
                left = right;
            }
        }
        return Math.max(max, right-left+1);
    }

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{1,1}));
    }
}

