package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * ��dp[i]��ʾ�ַ��� s ��ǰ i ���ַ� s[1..i] �Ľ��뷽����
     * ��һ�����: ��s[i]���е����ַ�����, ֻҪs[i] != 0, ��dp[i] = dp[i-1]
     * �ڶ������: ��s[i-1],s[i]�����ַ����н���, ��Ҫs[i-1] != 0 && s[i-1,i]���С��'26', ��dp[i] = dp[i-2]
     */
    public static int numDecodings(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        //��һ���ַ�Ϊ'0', �޷�����
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++) {
            //���������������ַ�'0'�����������ֵ������ַ�����'20', ˵���޷�����
            if (i > 1 &&chars[i - 1] == '0' && (chars[i - 2] == '0' || chars[i - 2] >= '3')) {
                return 0;
            }
            if (chars[i - 1] != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && chars[i - 2] != '0' && ((chars[i-2] - '0') * 10 + chars[i-1] - '0' <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("2611055971756562"));
    }
}





