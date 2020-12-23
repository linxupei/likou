package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * ����ͳ��ÿһ���ַ����ֵĸ���
     * Ȼ������ַ����ж��Ƿ��г��ִ���Ϊ1���ַ�,
     * ���򷵻��±꼴��
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int []frequent = new int[26];
        for (int i = 0; i < length; i++) {
            frequent[chars[i]-'a']++;
        }
        for (int i = 0; i < length; i++) {
            if (frequent[chars[i]-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }
}

