package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    /**
     * ����������ͬ�ַ�, ɾ��������ͬ���ַ���, ���±����0, �����һλ
     * �������ַ���ͬ��ǰ��һλ
     */
    public static String removeDuplicates(String S) {
        StringBuffer stringBuffer = new StringBuffer(S);
        int index = 0;
        while (stringBuffer.length() > 0 && index < stringBuffer.length() - 1) {
            if (stringBuffer.length() > 1 && stringBuffer.charAt(index) == stringBuffer.charAt(index+1)) {
                stringBuffer.delete(index, index+2);
                if (index > 0) {
                    index--;
                }
            } else {
                index++;
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("a"));
    }
}

