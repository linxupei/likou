package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ͨ�����������Ļ�������ԭ��, ÿ��������1
     * �����ƴ���, ͳ�ƴ��ڳ���
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

