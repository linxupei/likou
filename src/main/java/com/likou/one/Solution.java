package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 仔细分析可知每次都让最小的两个组合在一起, 这样才能获得最大的总和
     * 比如, 有四个数, x1<x2<x3<x4
     * 若不让x1与x2组合, 那么必有一个较大值(x3或x4)与之组合
     * 那么最后只能得到两个较小值的总和
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int length = nums.length;
        for (int i = 0; i < length; i+=2) {
            result += nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,2,4,3}));
    }
}

