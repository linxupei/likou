package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 设爱丽丝糖果总量为sum1, 需交换x, 鲍勃糖果总量为sum2, 需交换y
     * 则sum1-x+y=sum2-y+x;
     * x = (sum1-sum2)/2 + y
     * 找出一个x, y满足上式即可
     **/
    public static int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0, sum2 = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            sum1 += A[i];
            hashSet.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            sum2 += B[i];
        }
        for (int i = 0; i < B.length; i++) {
            int a = (sum1-sum2)/2 + B[i];
            if (hashSet.contains(a)) {
                result[0] = a;
                result[1] = B[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fairCandySwap(new int[]{1,1}, new int[]{2,2}));
    }
}

