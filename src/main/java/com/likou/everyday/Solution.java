package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * ���Խ�ʹ����������������
     *
     * dp[i]��ʾС͵������i�䷿���ǿ���͵������С���
     * dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
     * ����ÿһ�䷿�ӵĽ����Բ�͵, Ҳ������ǰһ�䷿��û��͵�������͵
     *
     */
    public static int robI(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i-1] + nums[i]);
        }
        return dp[length];
    }

    /**
     * ��һ�䷿�Ӻ����һ�䷿�Ӳ���ͬʱ͵��
     * ��˱Ƚ�͵[0, n-1]��[1,n]��ȡֵ����
     */
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robI(Arrays.copyOfRange(nums,0,length-1)), robI(Arrays.copyOfRange(nums,1,length)));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,3,1,3,100}));
    }
}




