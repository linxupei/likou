package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * �����ַ��������������ַ�����ϵ�����
     * 1.���Ȳ���
     * 2.�ַ�������Ŀ����
     * �������ҹ�ϵ
     * 1.ֱ�����
     * 2.1 û�н���λ��
     * 2.2 ������λ��
     */
    //������������, -1��ʾfalse, 1��ʾtrue, 0��ʾδ����
    int[][][] memo;
    String s1, s2;
    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int length = s1.length();
        this.memo = new int[length][length][length + 1];
        return dfs(0, 0, length);
    }

    public boolean dfs(int i1, int i2, int length) {
        if (memo[i1][i2][length] != 0) {
            return memo[i1][i2][length] == 1;
        }
        //�ж������ַ����Ƿ����
        if (s1.substring(i1, i1 + length).equals(s2.substring(i2, i2 + length))) {
            memo[i1][i2][length] = 1;
            return true;
        }
        if (!checkIfSimilar(i1, i2, length)) {
            memo[i1][i2][length] = -1;
            return false;
        }
        //ö��λ��
        for (int i = 1; i < length; i++) {
            //û�н���λ��
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
            //����λ��
            if (dfs(i1, i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
        }
        memo[i1][i2][length] = -1;
        return false;
    }

    /**
     * �ж������ַ����Ƿ�����
     */
    public boolean checkIfSimilar(int i1, int i2, int length) {
        int []frequency = new int[26];
        for (int i = i1; i < i1 + length; i++) {
            frequency[s1.charAt(i) - 'a']++;
        }
        for (int i = i2; i < i2 + length; i++) {
            frequency[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}




