package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ͨ����ϣ��������������������ֵ�λ�á������ֵ�λ���Լ����ֵ�Ƶ��
     * ������ĳ�����ֳ��ֵ�Ƶ�����ʱ����Ƶ�ʺܿ��ܾ�������Ķȣ�ֱ�����ĩλ��֮���
     * �������������ֵĳ���Ƶ�ʶ�һ��ʱ��ѡȡ�������ֵĳ�ĩλ��֮���н�С��
     */
    public static int findShortestSubArray(int[] nums) {
        int length = nums.length;
        int max = 1, min = 1;
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], new int[]{i, i, 1});
            } else {
                int[] temp = hashMap.get(nums[i]);
                hashMap.put(nums[i], new int[]{temp[0], i, temp[2]+1});
                if (temp[2]+1 > max) {
                    min = i - temp[0] + 1;
                    max = temp[2]+1;
                } else if (temp[2]+1 == max) {
                    if (i - temp[0] < min) {
                        min = i - temp[0] + 1;
                    }
                }
            }
        }
        return min;
    }

    /**
     * ������Ŀ�涨��nums[i]�ķ�Χ, ���Ҳ����ֱ�Ӵ���һ��nums[i]�ķ�Χ��С������
     */
    public static int findShortestSubArray_(int[] nums) {
        int[][] count = new int[50000][3];
        int max = 0, min = 0;
        int length = nums.length;
        for (int i = 0; i < 50000; i++) {
            count[i][0] = -1;
            count[i][1] = -1;
        }
        for (int i = 0; i < length; i++) {
            if (count[nums[i]][0] == -1) {
                count[nums[i]][0] = i;
            }
            count[nums[i]][1] = i;
            count[nums[i]][2]++;
            if (count[nums[i]][2] >= max) {
                int value = count[nums[i]][1] - count[nums[i]][0];
                if (value <= min || count[nums[i]][2] > max) {
                    min = value + 1;
                }
                max = count[nums[i]][2];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2}));
    }
}

