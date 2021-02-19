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
            //代表当前位置发生的翻转次数
            revCnt += diff[i];
            //由于数字只有0或1, 若当前数字加翻转次数为偶数
            //则经过说明revCnt次翻转后, 当前数字为0
            //当前位置任然需要进行一次翻转
            if ((revCnt + A[i])%2 == 0) {
                //最后一个小于K的区间任然有0, 无法再进行翻转
                if (i+K > length) {
                    return -1;
                }
                //翻转次数加1
                result++;
                //当前位置翻转次数加1
                revCnt++;
                //下一个区间的初始位置翻转次数减1, 即相对于前一个区间少翻转一次
                //到达这个位置时需要减少一次翻转次数
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
                //当剩余的元素小于K, 此时已无法翻转
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
                //情况1: K=0, 且数组元素不全为1;
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

