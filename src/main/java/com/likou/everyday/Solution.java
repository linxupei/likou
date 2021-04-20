package com.likou.everyday;


import java.util.*;

public class Solution {
    public static int strStr(String haystack, String needle) {
        if (needle == null ||needle.equals("")) {
            return 0;
        }
        int hayLength = haystack.length();
        int neeLength = needle.length();
        if (neeLength > hayLength) {
            return -1;
        }
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        //用于记录遍历needle的下标, 当index == neeLength - 1
        //即可确认haystack中存在子串needle
        int index = 0;
        int pre = -1;
        for (int i = 0; i + neeLength < hayLength; i++) {
            if (hay[i] == nee[0] && index != 0 && pre == -1) {
                pre = i;
            }
            if (hay[i] == nee[index]) {
                index++;
                if (index == neeLength) {
                    return i - neeLength + 1;
                }
            } else {
                if (index != 0 && pre != -1) {
                    i = pre - 1;
                    pre = -1;
                }
                index = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "pi"));
    }
}





