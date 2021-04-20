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
        //���ڼ�¼����needle���±�, ��index == neeLength - 1
        //����ȷ��haystack�д����Ӵ�needle
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





