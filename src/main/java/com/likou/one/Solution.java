package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ������[left, right]������������������
     * ��ô����right����, left�仯
     * һ�������һ��i<=left<=j������ʹ��[left, right]����������
     * ��left��Сһ��(����>K)���ٴ�һ��(����<K)������������,
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

