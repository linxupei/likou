package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ��ϸ������֪ÿ�ζ�����С�����������һ��, �������ܻ�������ܺ�
     * ����, ���ĸ���, x1<x2<x3<x4
     * ������x1��x2���, ��ô����һ���ϴ�ֵ(x3��x4)��֮���
     * ��ô���ֻ�ܵõ�������Сֵ���ܺ�
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

