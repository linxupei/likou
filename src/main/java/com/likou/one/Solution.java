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
                    //若当前下标为0, 则使他变小一点
                    nums[i] = nums[i+1];
                } else if (i == length - 2) {
                    //若当前下标为length-2, 则使最后一个位置变大一点
                    nums[length - 1] = nums[length - 2];
                } else {
                    if (nums[i+1] >= nums[i-1]) {
                        //若该情况类似...7, 1, 8..., 则使当前位置变小一点
                        nums[i] = nums[i-1];
                    } else {
                        //若该情况类似...7, 8, 2..., 则下一个位置变大一点
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

