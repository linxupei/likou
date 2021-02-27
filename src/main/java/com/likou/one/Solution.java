package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * ֻ��Ҫ�ж��Ƿ�ͬʱ���ڵ����͵ݼ������
     * ����������Ϊ����
     * add�ж��Ƿ���ڵ���
     * sub�ж��Ƿ���ڵݼ�
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

