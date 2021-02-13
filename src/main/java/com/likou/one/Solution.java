package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 由于数组中的的数字范围在[0,n], 那么以每个数字为下标
     * 将该下标的值加n, 那么若不存在某个数字, 那么该下标的值
     * 就不会大于n
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

