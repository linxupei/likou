package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ���Ȱ������ַ�֮��Ĳ�ֵ�ҳ���, ������Ϊ��
     * Ȼ��ͨ��������Ļ�������, �ѷ����������Ӵ��ҳ���
     * ��������: total > maxCost(�����ڻ���С����󻨷�)
     */
    public static int equalSubstring(String s, String t, int maxCost) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int length = sChars.length;
        int[] differ = new int[length];
        int total = 0;
        int left = 0, right = 0;
        for (int i = 0; i < length; i++) {
            differ[i] = Math.abs(tChars[i] - sChars[i]);
        }
        while (right < length) {
            int temp = differ[right];
            total += temp;
            right++;
            if (total > maxCost) {
                total -= differ[left];
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(equalSubstring(new String("krrgw"), new String("zjxss"), 19));
    }
}

