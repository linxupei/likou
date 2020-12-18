package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * ͳ���ַ���s���ַ�Ƶ��
     * ��ͳ���ַ���t���ַ�Ƶ��
     * ��ĳ���ַ����ֵ�Ƶ�ʲ�һ��, �򷵻ؼ���
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
     * ͨ��(^���)λ����ɰѳ��ִ���Ϊż�ε��ַ�ȥ��
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
     * ͨ�������ַ���ASCII��ֵ�ܺ����
     * ��ֵ��Ϊ����ӵ��ַ�
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

