package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ˳������б���
     * ��Ҫע�����һ���Ƿ����2
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new LinkedList<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int start = 0;
        char current = chars[0];
        for (int i = 1; i < length; i++) {
            if (chars[i] != current) {
                if (i - start > 1) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(start);
                    temp.add(i - 1);
                    result.add(temp);
                }
                start = i;
                current = chars[i];
            }
        }
        if (length - start > 2) {
            List<Integer> temp = new LinkedList<>();
            temp.add(start);
            temp.add(length - 1);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

