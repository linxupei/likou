package com.likou.one;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * 步骤中, 子串[left, right)不一定是符合条件的子串, 但该长度结果存在
     */
    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] frequent = new int[26];
        int length = chars.length;
        int left = 0, right = 0;
        int max = 0;
        while (right < length) {
            frequent[chars[right] - 'A']++;
            max = Math.max(max, frequent[chars[right] - 'A']);
            //加1是由数组下标从0开始, 因此此时长度需要加1
            //由于不需要维护max, max一直在非递减, 因此只需要用if判断一次
            //若需求根据实际过程维护max, 可用while
            if (right - left + 1 > max + k) {
                frequent[chars[left] - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        characterReplacement("AABABBA", 1);
    }
}

