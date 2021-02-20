package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 滑动窗口, K的大小即子串允许存在多少个0
     * 以right为子串右边界, left为子串左边界
     * 当子串出现0的次数大于K时, 统计子串的长度,
     * 并将left移动到使子串0的次数不大于K的位置
     * right为主动移动, left为被动移动
     */
    public static int longestOnes(int[] A, int K) {
        int max = 0;
        int left = 0, right = 0;
        int flag = 0;
        int length = A.length;
        while (right < length) {
            if (A[right] == 0) {
                K--;
                if (K == 0 && flag <= left) {
                    flag = right;
                }
                if (K < 0) {
                    max = Math.max(max, right-left);
//                    left = flag;
//                    flag = right;
//                    K++;
                    while (K < 0) {
                        if (A[left] == 0) {
                            K++;
                        }
                        left++;
                    }
                }
            }
            right++;
        }
        return Math.max(max, right-left);
    }


    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}

