package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 分成3种情况讨论, 设下标l, r对应位置为1
     * 1.(l, r)间全为0, 可供种植的位置有l-r-2, 最多种植(l-r-2)/2
     * 2.l左边全为0, 可供种植的位置为l-1, 最多种植(l-1)/2
     * 3.r右边全为0, 可供种植的位置为length-r-1, 最多种植(length-r-1)/2
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pre = -1;
        int length = flowerbed.length;
        int total = 0;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                if (pre < 0) {
                    //第二种情况
                    total += (i / 2);
                } else {
                    //第一种情况
                    total += ((i - pre - 2) / 2);
                }
                pre = i;
            }
        }
        if (pre < 0) {
            //第一种情况
            total += ((length + 1) / 2);
        } else {
            //第三种情况
            total += ((length - pre - 1) / 2);
        }
        return total >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}

