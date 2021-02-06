package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 按照公式逐步求解即可
     */
    public int fib(int n) {
        int a = 1, b = 0;
        int index = 1;
        if (n == 0) {
            return b;
        }
        if (n == 1) {
            return a;
        }
        while (index < n) {
            int temp = a;
            a = a + b;
            b = temp;
            index++;
        }
        return a;
    }

    public static void main(String[] args) {

    }
}

