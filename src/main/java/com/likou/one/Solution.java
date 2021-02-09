package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 设区间[left, right]是满足条件的子区间
     * 那么保持right不变, left变化
     * 一定会存在一个i<=left<=j的区间使得[left, right]是满足条件
     * 当left再小一点(种类>K)或再大一点(种类<K)都不满足条件,
     */
    public static int subarraysWithKDistinct(int[] A, int K) {
        int length = A.length;
        int total1 = 0, total2 = 0;
        int result = 0;
        int[] num1 = new int[length+1], num2 = new int[length+1];
        int left1 = 0, left2 = 0, right = 0;
        while (right < length) {
            if (num1[A[right]] == 0) {
                total1++;
            }
            num1[A[right]]++;
            if (num2[A[right]] == 0) {
                total2++;
            }
            num2[A[right]]++;
            while (total1 > K) {
                num1[A[left1]]--;
                if (num1[A[left1]] == 0) {
                    total1--;
                }
                left1++;
            }
            while (total2 > K-1) {
                num2[A[left2]]--;
                if (num2[A[left2]] == 0) {
                    total2--;
                }
                left2++;
            }
            result += left2 - left1;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2}, 1));
    }
}

