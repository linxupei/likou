package com.likou.everyday;


import java.util.*;

public class Solution {

    /**
     * 排序+动态规划+贪心
     * dp[i][0]表示能nums[i]整除的数字有几个,
     * dp[i][1]表示nums[0..i]中能被nums[i]整除的最大值的下标为
     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        List<Integer> ret = new ArrayList<Integer>();
        Arrays.sort(nums);
        int [][]dp = new int[length][2];
        dp[0][0] = 1;
        dp[0][1] = -1;
        //记录整除子集最多元素的值, 以及相应下标
        int[] max = new int[2];
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                //对于一个数可能会有多条分支, 如: 18(分支一: 1,2,9,18) 18(分支二: 1,3,9,18)
                if (nums[i] % nums[j] == 0 && dp[j][0] + 1 > dp[i][0]) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                    flag = true;
                    if (dp[i][0] > max[0]) {
                        max[0] = dp[i][0];
                        max[1] = i;
                    }
                }
            }
            //nums[i]无法被num[0..i)中任何一个数整除
            if (!flag) {
                dp[i][0] = 1;
                dp[i][1] = -1;
            }
        }
        //将相应的整除链输出即可
        while (max[1] != -1) {
            ret.add(nums[max[1]]);
            max[1] = dp[max[1]][1];
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1,2,4,8}));
    }
}





