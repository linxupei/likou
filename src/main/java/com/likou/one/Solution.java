package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ��������, K�Ĵ�С���Ӵ�������ڶ��ٸ�0
     * ��rightΪ�Ӵ��ұ߽�, leftΪ�Ӵ���߽�
     * ���Ӵ�����0�Ĵ�������Kʱ, ͳ���Ӵ��ĳ���,
     * ����left�ƶ���ʹ�Ӵ�0�Ĵ���������K��λ��
     * rightΪ�����ƶ�, leftΪ�����ƶ�
     */
    public static int longestOnes(int[] A, int K) {
        int max = 0;
        int left = 0, right = 0;
        int flag = 0;
        int length = A.length;
        while (right < length) {
            if (A[right] == 0) {
                K--;
                if (K == 0 && flag <= left) {
                    flag = right;
                }
                if (K < 0) {
                    max = Math.max(max, right-left);
//                    left = flag;
//                    flag = right;
//                    K++;
                    while (K < 0) {
                        if (A[left] == 0) {
                            K++;
                        }
                        left++;
                    }
                }
            }
            right++;
        }
        return Math.max(max, right-left);
    }


    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}

