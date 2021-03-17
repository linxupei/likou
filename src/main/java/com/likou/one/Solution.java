package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    /**
     * m = s.length(), n = t.length()
     * dp[i][j]��s[i:]��t[j]���ֵĴ���(s[i:]��ʾ�ַ������Ӵ�s.sub(i,s.length()))
     * ��i>=m �� j<n ʱ s[i:]Ϊ�մ�, ���dp[i][j] = 0;
     * ��j>=n ʱ, t[j:]Ϊ�մ�, �մ��������κ��ַ������Ӵ�
     * ��i<m �� j<n ʱ,
     *      ��s[i]==t[j],
     *          ��ѡ��s[i]��t[j]ƥ���ʱ��, ����t[j+1:]��Ϊs[t+1:]��������, ��������Ϊdp[i+1][j+1]
     *          ����ѡ��s[i]��t[j]ƥ���ʱ��, ����t[j:]��Ϊs[t+1:]��������, ��������Ϊdp[i+1][j]
     *          ��:s="bagag",t="bag", s[4]==t[2], ����ƥ��, Ҳ����ѡ��ƥ��, ��ƥ����Ϊs[0]s[1]s[2]
     *          ���dp[i][j]=dp[i+1][j+1]+dp[i+1][j]
     *      ��s[i]!=t[j],
     *          dp[i][j]=dp[i+1][j]
     */
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                if (ch == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        //spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}

