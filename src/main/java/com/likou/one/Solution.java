package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * 首先统计每一个字符出现的个数
     * 然后遍历字符串判断是否有出现次数为1的字符,
     * 有则返回下标即可
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

