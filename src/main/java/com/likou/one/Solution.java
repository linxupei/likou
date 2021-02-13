package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    //按照公式求解即可cur[j] = pre[j-1] + pre[j];
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        int[] cur = new int[rowIndex+1];
        int[] pre = new int[rowIndex+1];
        pre[0] = 1;
        pre[1] = 1;
        if (rowIndex < 2) {
            for (int i = 0; i <= rowIndex; i++) {
                result.add(1);
            }
        } else {
            for (int i = 1; i < rowIndex; i++) {
                cur[0] = 1;
                for (int j = 1; j <= i; j++) {
                    cur[j] = pre[j-1] + pre[j];
                }
                cur[i+1] = 1;
                pre = Arrays.copyOf(cur, i+2);
            }
            for (int i = 0; i < rowIndex; i++) {
                result.add(cur[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}

