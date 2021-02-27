package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * 只需要判断是否同时存在递增和递减的情况
     * 若不存在则为单调
     * add判断是否存在递增
     * sub判断是否存在递减
     */
    public static boolean isMonotonic(int[] A) {
        boolean add = false, sub = false;
        int length = A.length;
        for (int i = 1; i < length; i++) {
            if (A[i] > A[i-1]) {
                add = true;
            }
            if (A[i] < A[i-1]) {
                sub = true;
            }
            if (add && sub) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
    }
}

