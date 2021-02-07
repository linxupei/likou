package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static boolean checkPossibility(int[] nums) {
        int times = 0;
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (i == 0) {
                    //����ǰ�±�Ϊ0, ��ʹ����Сһ��
                    nums[i] = nums[i+1];
                } else if (i == length - 2) {
                    //����ǰ�±�Ϊlength-2, ��ʹ���һ��λ�ñ��һ��
                    nums[length - 1] = nums[length - 2];
                } else {
                    if (nums[i+1] >= nums[i-1]) {
                        //�����������...7, 1, 8..., ��ʹ��ǰλ�ñ�Сһ��
                        nums[i] = nums[i-1];
                    } else {
                        //�����������...7, 8, 2..., ����һ��λ�ñ��һ��
                        nums[i+1] = nums[i];
                    }
                }
                times++;
            }
        }
        return times <= 1;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{5,7,1,8}));
    }
}

