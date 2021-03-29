package com.likou.everyday;


import java.util.*;



public class Solution {

    /**
     * 循环取出每一个位二进制, 放到相应位置
     */
    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            result |= (n & 1) << (31 - i);
            n = n >>> 1;
        }
        return result;
    }

    /**
     * 分治
     * n = n1n2
     * (n1X-->Xn1,   Xn2-->n2X)-->n2n1
     */
    public int reverseBits(int n) {
        n = (n >>> 1 & 0x55555555) | ((n & 0x55555555) << 1);
        n = (n >>> 2 & 0x33333333) | ((n & 0x33333333) << 2);
        n = (n >>> 4 & 0x0F0F0F0F) | ((n & 0x0F0F0F0F) << 4);
        n = (n >>> 8 & 0x00FF00FF) | ((n & 0x00FF00FF) << 8);
        return n >>> 16 | n << 16;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3));
    }
}

