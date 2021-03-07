package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    static int n;
    //����һ����
    //static boolean[][] f;
    static int[][] judge;
    static List<List<String>> result;
    static List<String> ans;

    //����һ: dfs+��̬�滮
    //������: ����+��������
    public static List<List<String>> partition(String s) {
        n = s.length();
        //����һ����
        //f = new boolean[n][n];
        judge = new int[n][n];
        result = new LinkedList<>();
        ans = new LinkedList<>();
        //����һ����
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(f[i], true);
//        }
        //��ѭ������, ��s[1,4]��Ҫ�ж�s[2,3], ����ʱi��Ϊ1, ��û��2, �޷���Ϊ��ȷ���
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                f[i][j] = f[i+1][j-1] && (s.charAt(i) == s.charAt(j));
//            }
//        }
        //����һ����
//        for (int i = n-1; i >= 0; i--) {
//            for (int j = i+1; j < n; j++) {
//                f[i][j] = f[i+1][j-1] && (s.charAt(i) == s.charAt(j));
//            }
//        }
        dfs(s, 0);
        return result;
    }

    public static void dfs(String s, int i) {
        if (i == n) {
            result.add(new LinkedList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            //����һ����
//            if (f[i][j]) {
//                ans.add(s.substring(i, j+1));
//                dfs(s, j+1);
//                //�ڴ�������, ɾ������Ԫ��, Ϊ��һ�׵ݹ���׼��
//                ans.remove(ans.size()-1);
//            }
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j+1));
                dfs(s, j+1);
                ans.remove(ans.size()-1);
            }
        }
    }

    //0-δ�ж�, 1-�ǻ��Ĵ�, 2-���ǻ��Ĵ�
    public static int isPalindrome(String s, int i, int j) {
        if (judge[i][j] != 0) {
            return judge[i][j];
        }
        if (i >= j) {
            judge[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            judge[i][j] = isPalindrome(s, i+1, j-1);
        } else {
            judge[i][j] = -1;
        }
        return judge[i][j];
    }

    public static void main(String[] args) {
        partition("abbab");
    }
}

