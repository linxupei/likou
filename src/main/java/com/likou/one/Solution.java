package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * frequent用于统计子字符串的每个字母出现的频率
     * account用于统计子字符串的字母种类个数
     * 当s2中的某个字符串使得account==0的时候说明存在答案
     */
    public static boolean checkInclusion(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = chars1.length, length2 = chars2.length;
        int[] frequent = new int[26];
        int account = 0;
        int min = Integer.MIN_VALUE;
        if (length1 > length2) {
            return false;
        }
        //值为min说明该字母没有出现在子字符串中
        Arrays.fill(frequent, min);
        for (char ch : chars1) {
            if (frequent[ch-'a'] == min) {
                account++;
                frequent[ch-'a'] = 0;
            }
            frequent[ch-'a']++;
        }
        for (int i = 0; i < length1; i++) {
            frequent[chars2[i]-'a']--;
            if (frequent[chars2[i]-'a'] == 0) {
                account--;
                if (account == 0) {
                    return true;
                }
            }
        }
        for (int i = 0; i < length2 - length1; i++) {
            if (frequent[chars2[i]-'a'] != min) {
                if (frequent[chars2[i]-'a'] == 0) {
                    account++;
                }
                frequent[chars2[i]-'a']++;
            }
            if (frequent[chars2[i+length1]-'a'] != min) {
                frequent[chars2[i+length1]-'a']--;
                if (frequent[chars2[i+length1]-'a'] == 0) {
                    account--;
                    if (account == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "ccccbbbbaaaa"));
    }
}

