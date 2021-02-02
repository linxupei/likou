package com.likou.one;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ������, �Ӵ�[left, right)��һ���Ƿ����������Ӵ�, ���ó��Ƚ������
     */
    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] frequent = new int[26];
        int length = chars.length;
        int left = 0, right = 0;
        int max = 0;
        while (right < length) {
            frequent[chars[right] - 'A']++;
            max = Math.max(max, frequent[chars[right] - 'A']);
            //��1���������±��0��ʼ, ��˴�ʱ������Ҫ��1
            //���ڲ���Ҫά��max, maxһֱ�ڷǵݼ�, ���ֻ��Ҫ��if�ж�һ��
            //���������ʵ�ʹ���ά��max, ����while
            if (right - left + 1 > max + k) {
                frequent[chars[left] - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }
}

