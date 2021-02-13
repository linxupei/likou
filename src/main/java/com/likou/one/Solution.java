package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ���������еĵ����ַ�Χ��[0,n], ��ô��ÿ������Ϊ�±�
     * �����±��ֵ��n, ��ô��������ĳ������, ��ô���±��ֵ
     * �Ͳ������n
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        int length = nums.length;
        for (int num : nums) {
            int x = (num - 1) % length;
            nums[x] += length;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] <= length) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

