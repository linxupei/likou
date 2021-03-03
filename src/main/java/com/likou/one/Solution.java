package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * bits[i]��ʾ����i�Ķ���������1�ĸ���
     * �����Чλ����
     * ��0<x<=y, yΪx�����λ����:X=101, Y=100����z=x-y
     * ��bits[x] = bit[x-y]+1;
     */
    public int[] countBits(int num) {
        int height = 0;
        int[] bits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            if ((i & (i-1)) == 0) {
                height = i;
            }
            bits[i] = bits[i-height] + 1;
        }
        return bits;
    }

    /**
     * bits[i]��ʾ����i�Ķ���������1�ĸ���
     * �����Чλ����
     * ����bits[x], ���֪��bits[(x>>1)]
     * ��x����ż����ʱ�� bits[x] = bits[(x>>1)]
     * ��x����������ʱ�� bits[x] = bits[(x>>1)] + 1
     */
    public int[] countBits_2(int num) {
        int[] bits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i>>1] + (i&1);
        }
        return bits;
    }

    /**
     * bits[i]��ʾ����i�Ķ���������1�ĸ���
     * �������λ����(�����ֵĶ�������С��1���ڵ�λ��)
     * ��y = x & (x-1), ��x���������Ϊ��Ϊ0����bits[x] = bits[y] + 1
     */
    public static int[] countBits_1(int num) {
        int[] bits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i & (i-1)] + 1;
        }
        return bits;
    }

    public static void main(String[] args) {

    }
}

