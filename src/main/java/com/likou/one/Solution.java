package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * 统计字符串s的字符频率
     * 再统计字符串t的字符频率
     * 若某个字符出现的频率不一致, 则返回即可
     */
    public static char findTheDifference1(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int []frequent = new int[26];
        for (int i = 0; i < charS.length; i++) {
            frequent[charS[i]-'a']++;
        }
        for (int i = 0; i < charT.length; i++) {
            frequent[charT[i]-'a']--;
            if (frequent[charT[i]-'a'] < 0) {
                return charT[i];
            }
        }
        return ' ';
    }

    /**
     * 通过(^异或)位运算可把出现次数为偶次的字符去掉
     * A^A=0
     */
    public static char findTheDifference2(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int result = 0;
        for (char aChar : charS) {
            result ^= aChar;
        }
        for (char c : charT) {
            result ^= c;
        }
        return (char) result;
    }

    /**
     * 通过两个字符串ASCII码值总和相减
     * 差值即为被添加的字符
     */
    public static char findTheDifference(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int as = 0, at = 0;
        for (char c : charS) {
            as += c;
        }
        for (char c : charT) {
            at += c;
        }
        return (char) (at - as);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}

