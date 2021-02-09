package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ���û������ڵ�ԭ��
     * [left,right]��ʾ����Ҫ��Ĵ��ڵķ�Χ
     * flag��ʾ���������ֵıȽ�
     * flag = 1, ��ʾ���������ֵĹ�ϵΪ����
     * flag = 0, ��ʾ���������ֵĹ�ϵΪ����
     * flag = -1, ��ʾ���������ֵĹ�ϵΪС��
     * ���������������Ҫ��ʱ, right����һλ
     * ������ʱ, �Ƚ�(max, right-left+1), ��right����һλ, Ȼ��right��ֵ��left,
     * ���¿�ʼ���㴰�ڳ���
     */
    public static int maxTurbulenceSize_(int[] arr) {
        int max = 0;
        int flag = 0;
        int left = 0, right = 0;
        int length = arr.length;
        if (length <= 1) {
            return length;
        }
        while (right < length - 1) {
            if (arr[right] > arr[right+1] && (flag < 0 || right == 0)) {
                right++;
                flag = 1;
            } else if (arr[right] < arr[right+1] && (flag > 0 || right == 0)) {
                right++;
                flag = -1;
            } else {
                max = Math.max(max, right - left + 1);
                while (right < length-1 && arr[right] == arr[right+1]) {
                    right++;
                }
                if (right < length-1 && arr[right] > arr[right+1]) {
                    flag = -1;
                } else {
                    flag = 1;
                }
                left = right;
            }

        }
        return Math.max(max, right - left + 1);
    }

    public static int maxTurbulenceSize(int[] arr) {
        int max = 0;
        boolean flag = true;
        int left = 0, right = 0;
        int length = arr.length;
        if (length <= 1) {
            return length;
        }
        while (right < length - 1) {
            if (flag) {
                right++;
                flag = false;
            } else if (arr[right-1] > arr[right] && arr[right] < arr[right+1]) {
                right++;
            } else if (arr[right-1] < arr[right] && arr[right] > arr[right+1]) {
                right++;
            } else {
                max = Math.max(max, right-left+1);
                while (right < length-1 && arr[right] == arr[right+1]) {
                    right++;
                }
                flag = true;
                left = right;
            }
        }
        return Math.max(max, right-left+1);
    }

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{1,1}));
    }
}

