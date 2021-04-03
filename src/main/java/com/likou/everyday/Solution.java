package com.likou.everyday;




public class Solution {

    /**
     * ��̬�滮
     * ע��dp������
     * dp[i][j]����text1[0...i]��text2[0...j]�������������
     * ��text1[i-1]==text2[j-1]ʱ, text[i][j] = text[i-1][j-1]+1
     * ��text1[i-1]!=text2[j-1]ʱ, text[i][j] = max(text[i][j-1],text[i-1][j])
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int [][]dp = new int[length1+1][length2+1];
        for (int i = 1; i <= length1; i++) {
            char ch = text1.charAt(i-1);
            for (int j = 1; j <= length2; j++) {
                if (text2.charAt(j-1) == ch) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        longestCommonSubsequence("abcde", "ace");
    }
}

