package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ����һ������(����Ϊ2k, �������˶����ܵ�������ֵ)���ڱ������ڴ��ڻ���������
     * �Ƚ�cardPoints���±�k-1->0��������, �ٽ��±�length->length-k��������
     * �����д��ڻ�������, ���ж�k==length?
     */
    public static int maxScore(int[] cardPoints, int k) {
        int[] points = new int[2 * k];
        int length = cardPoints.length;
        int total = 0;
        int max = 0;
        for (int i = k - 1; i >= 0; i--) {
            points[k - 1 - i] = cardPoints[i];
            total += cardPoints[i];
        }
        max = total;
        for (int i = length - 1; i >= length - k; i--) {
            points[length + k - 1 - i] = cardPoints[i];
        }
        if (k != length) {
            for (int i = k; i < 2 * k; i++) {
                total += points[i];
                total -= points[i-k];
                max = Math.max(max, total);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }
}

