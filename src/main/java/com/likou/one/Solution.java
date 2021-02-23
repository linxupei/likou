package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ��ͳ���ϰ�û�������Լ�������֮ǰ�Ĺ˿�������
     * ��ͨ�����������ҳ����˿Ͳ�����X���ʱ��
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int result = 0;
        int max = 0;
        int temp = 0;
        int length = customers.length;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                max += customers[i];
            } else {
                result += customers[i];
            }
        }
        temp = max;
        for (int i = X; i < length; i++) {
            temp += customers[i] * grumpy[i];
            temp -= customers[i-X] * grumpy[i-X];
            if (grumpy[i] == 0) {
                result += customers[i];
            }
            max = Math.max(max, temp);
        }
        return result+max;
    }


    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5},
                                        new int[]{0,1,0,1,0,1,0,1}, 3));
    }
}

