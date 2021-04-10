package com.likou.everyday;


import java.util.Arrays;
import java.util.regex.Matcher;

public class Solution {

    /**
     * ³óÊı: n = 2^(a) * 3^(b) * 5^(c)
     */
    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int m = n;
        int []factors = new int[]{2,3,5};
        for (int factor : factors) {
            while (m % factor == 0) {
                m /= factor;
            }
        }
        return m == 1;
    }


    public static void main(String[] args) {
        System.out.println(isUgly(25));
    }
}

