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
     * dp[i][j]在s[i:]中t[j]出现的次数(s[i:]表示字符串的子串s.sub(i,s.length()))
     * 当i>=m 且 j<n 时 s[i:]为空串, 因此dp[i][j] = 0;
     * 当j>=n 时, t[j:]为空串, 空串可以是任何字符串的子串
     * 当i<m 且 j<n 时,
     *      若s[i]==t[j],
     *          当选择s[i]与t[j]匹配的时候, 则考虑t[j+1:]作为s[t+1:]的子序列, 字序列数为dp[i+1][j+1]
     *          当不选择s[i]与t[j]匹配的时候, 则考虑t[j:]作为s[t+1:]的子序列, 字序列数为dp[i+1][j]
     *          如:s="bagag",t="bag", s[4]==t[2], 可以匹配, 也可以选择不匹配, 不匹配则为s[0]s[1]s[2]
     *          因此dp[i][j]=dp[i+1][j+1]+dp[i+1][j]
     *      若s[i]!=t[j],
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

