package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Solution {
    /**
     * 普通的求二进制含有1的个数的方法
     */
    public int hammingWeight(int n) {
        Integer.bitCount(n);
        int count = 0;
        while (n != 0) {
            //通过该式可减少二进制的最低的1
            //10110 & (10101) = 10100
            n = (n & (n-1));
            count++;
        }
        return count;
    }

    /**
     * 汉明解法
     */
    public int hammingWeight1(int n) {
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) + ((n >> 4) & 0x0F0F0F0F);
        n = (n * 0x01010101 >> 24);
        return n;
    }



    public static void main(String[] args) {

    }
}

