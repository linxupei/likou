package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    /**
     * 遇到两个相同字符, 删除两个相同的字符后, 若下标大于0, 则后退一位
     * 若两个字符不同则前进一位
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

