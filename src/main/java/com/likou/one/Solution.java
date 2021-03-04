package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    /**
     * ���ֲ��ҷ�+��̬�滮
     * ʹ��ͬw, h�Ӵ�С����Ϊ�˱������ͬһ��wȡ���h�����
     */
    public static int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        if (length == 0) {
            return 0;
        }
        List<Integer> f = new LinkedList<>();
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0] ? a[0]-b[0] : b[1]-a[1]));
        f.add(envelopes[0][1]);
        for (int i = 1; i < length; i++) {
            int num = envelopes[i][1];
            if (num > f.get(f.size()-1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public static int binarySearch(List<Integer> f, int target) {
        int low = 0, height = f.size()-1;
        while (low < height) {
            int mid = (height - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                height = mid;
            }
        }
        return low;
    }

    /**
     * ƽƽ����Ķ�̬�滮
     * ������, ��ȡ�����б�envelopes[i]С��envelopes[j]�����ֵ��1(j < i)
     * ��Ϊdp[i], ����i����ȡ�õ���Ӵ�
     */
    public int maxEnvelopes_1(int[][] envelopes) {
        int length = envelopes.length;
        if (length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[length];
        dp[0] = 1;
        Arrays.sort(envelopes, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * ���ֲ��ҷ�+��̬�滮
     * tail�����д洢�Ŀ��ܲ������������Ӵ�����
     */
    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] tails = new int[length];
        int len = 0;
        for (int num : nums) {
            int low = 0, height = len;
            while (low < height) {
                int mid = (height + low) / 2;
                if (tails[mid] < num) {
                    low = mid + 1;
                } else {
                    height = mid;
                }
            }
            tails[low] = num;
            if (len == height) {
                len++;
            }
        }
        return len;
    }

    /**
     * ʹ�ö�̬�滮
     */
    public int lengthOfLIS_1(int[] nums) {
        int length = nums.length;
        int []dp = new int[length];
        int result = 0;
        for (int i = 1; i < length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    result = Math.max(dp[i], result);
                }
            }
        }
        return result+1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,7,3,101,18}));
        //System.out.println(maxEnvelopes(new int[][]{{1, 0}, {1, 1}, {1, 2}, {2, 1}, {3, 5}, {4, 3}, {5, 6}}));
    }
}

