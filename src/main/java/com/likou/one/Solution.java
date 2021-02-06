package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * �ֳ�3���������, ���±�l, r��Ӧλ��Ϊ1
     * 1.(l, r)��ȫΪ0, �ɹ���ֲ��λ����l-r-2, �����ֲ(l-r-2)/2
     * 2.l���ȫΪ0, �ɹ���ֲ��λ��Ϊl-1, �����ֲ(l-1)/2
     * 3.r�ұ�ȫΪ0, �ɹ���ֲ��λ��Ϊlength-r-1, �����ֲ(length-r-1)/2
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pre = -1;
        int length = flowerbed.length;
        int total = 0;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 1) {
                if (pre < 0) {
                    //�ڶ������
                    total += (i / 2);
                } else {
                    //��һ�����
                    total += ((i - pre - 2) / 2);
                }
                pre = i;
            }
        }
        if (pre < 0) {
            //��һ�����
            total += ((length + 1) / 2);
        } else {
            //���������
            total += ((length - pre - 1) / 2);
        }
        return total >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}

