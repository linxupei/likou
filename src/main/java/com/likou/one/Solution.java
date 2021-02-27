package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * 种类+滑动窗口
     * 本题中种类为字符串小写字母种类
     */
    public static int longestSubstring(String s, int k) {
        int result = 0;
        int length = s.length();
        for (int i = 1; i <= 26; i++) {
            int l = 0, r = 0;
            //统计[l, r]区间的字母频率
            int[] frequent = new int[26];
            //总的种类
            int total = 0;
            //少于k的种类
            int less = 0;
            while (r < length) {
                int index = s.charAt(r)-'a';
                frequent[index]++;
                //这是一个全新的种类
                if (frequent[index] == 1) {
                    total++;
                    less++;
                }
                //这个种类达到了最低标准
                if (frequent[index] == k) {
                    less--;
                }
                while (total > i) {
                    index = s.charAt(l)-'a';
                    frequent[index]--;
                    //这个种类无法达到最低标准
                    if (frequent[index] == k-1) {
                        less++;
                    }
                    //这个种类被移除了
                    if (frequent[index] == 0) {
                        total--;
                        less--;
                    }
                    l++;
                }
                //没有一个种类无法达到标准
                if (less == 0) {
                    result = Math.max(result, r-l+1);
                }
                r++;
            }
        }
        return result;
    }

    /**
     * 分治, 每一个不足k次的字母都可以作为一个分隔线, 将字符串分隔成若干部分
     */
    public static int longestSubstring_(String s, int k) {
        int length = s.length();
        return dfs(s, 0, length-1, k);
    }

    public static int dfs(String s, int l, int r, int k) {
        int[] frequent = new int[26];
        //统计某一个子串的字母数量
        for (int i = l; i <= r; i++) {
            frequent[s.charAt(i)-'a']++;
        }

        //找到一个分隔符
        //注: 为什么不是找第一个分隔符?
        //由于子串可能过长, 且在后续的递归中, 会继续找分隔, 因此不必
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (frequent[i] > 0 && frequent[i] < k) {
                split = (char) (i+'a');
                break;
            }
        }

        //若没有分隔符, 说明当前子串符合要求
        if (split == 0) {
            return r-l+1;
        }

        int i = l;
        int result = 0;
        while (i <= r) {
            //找到一个非分隔符的位置
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }
            int length = dfs(s, start, i-1, k);
            result = Math.max(length, result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc", 2));
    }
}

