package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int minKBitFlips(int[] A, int K) {
        int length = A.length;
        int result = 0;
        int[] diff = new int[length+1];
        int revCnt = 0;
        for (int i = 0; i < length; i++) {
            //����ǰλ�÷����ķ�ת����
            revCnt += diff[i];
            //��������ֻ��0��1, ����ǰ���ּӷ�ת����Ϊż��
            //�򾭹�˵��revCnt�η�ת��, ��ǰ����Ϊ0
            //��ǰλ����Ȼ��Ҫ����һ�η�ת
            if ((revCnt + A[i])%2 == 0) {
                //���һ��С��K��������Ȼ��0, �޷��ٽ��з�ת
                if (i+K > length) {
                    return -1;
                }
                //��ת������1
                result++;
                //��ǰλ�÷�ת������1
                revCnt++;
                //��һ������ĳ�ʼλ�÷�ת������1, �������ǰһ�������ٷ�תһ��
                //�������λ��ʱ��Ҫ����һ�η�ת����
                diff[i+K]--;
            }
        }
        return result;
    }

    public static int minKBitFlips_timeout(int[] A, int K) {
        int length = A.length;
        int left = 0;
        int result = 0;
        while (left < length) {
            if (A[left] == 0) {
                //��ʣ���Ԫ��С��K, ��ʱ���޷���ת
                if (left > length-K) {
                    return -1;
                }
                boolean flag = false;
                int temp = left+K-1;
                for (int i = left; i < left+K; i++) {
                    if (A[i] == 1) {
                        A[i] = 0;
                        if (!flag) {
                            temp = i - 1;
                            flag = true;
                        }
                    } else {
                        A[i] = 1;
                    }
                }
                left = temp;
                result++;
                //���1: K=0, ������Ԫ�ز�ȫΪ1;
                if (A[left] == 0) {
                    return -1;
                }
            }
            left++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3));
    }
}

