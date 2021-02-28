package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * Ç°×ººÍ
     */
    class NumArray {
        private int[] nums;
        private int[] sum;


        public NumArray(int[] nums) {
            int length = nums.length;
            this.nums = new int[length];
            sum = new int[length+1];
            for (int i = 0; i < length; i++) {
                this.nums[i] = nums[i];
                sum[i+1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j] - sum[i];
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

