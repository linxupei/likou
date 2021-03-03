package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * bits[i]表示数字i的二进制数的1的个数
     * 最高有效位计算
     * 设0<x<=y, y为x的最高位（例:X=101, Y=100），z=x-y
     * 则bits[x] = bit[x-y]+1;
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
     * bits[i]表示数字i的二进制数的1的个数
     * 最低有效位计算
     * 对于bits[x], 如果知道bits[(x>>1)]
     * 当x等于偶数的时候 bits[x] = bits[(x>>1)]
     * 当x等于奇数的时候 bits[x] = bits[(x>>1)] + 1
     */
    public int[] countBits_2(int num) {
        int[] bits = new int[num+1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i>>1] + (i&1);
        }
        return bits;
    }

    /**
     * bits[i]表示数字i的二进制数的1的个数
     * 最低设置位计算(即数字的二进制最小的1所在的位置)
     * 令y = x & (x-1), 将x的最低设置为变为0，则bits[x] = bits[y] + 1
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

