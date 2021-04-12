package com.likou.everyday;


import lombok.extern.java.Log;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.regex.Matcher;

public class Solution {



    /**
     * 直接比较两个字符串拼接后的不同值
     */
    public static String largestNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        for (int i = 0; i < length; i++) {
            result.append(strs[i]);
        }
        String ans = result.toString();
        return ans.charAt(0) == '0' ? "0" : ans;
    }


    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3636,36}));
    }
}

