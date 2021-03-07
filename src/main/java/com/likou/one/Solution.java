package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    static int n;
    //方法一内容
    //static boolean[][] f;
    static int[][] judge;
    static List<List<String>> result;
    static List<String> ans;

    //方法一: dfs+动态规划
    //方法二: 回溯+记忆搜索
    public static List<List<String>> partition(String s) {
        n = s.length();
        //方法一内容
        //f = new boolean[n][n];
        judge = new int[n][n];
        result = new LinkedList<>();
        ans = new LinkedList<>();
        //方法一内容
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(f[i], true);
//        }
        //此循环不行, 如s[1,4]需要判断s[2,3], 但此时i仅为1, 还没到2, 无法作为正确结果
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                f[i][j] = f[i+1][j-1] && (s.charAt(i) == s.charAt(j));
//            }
//        }
        //方法一内容
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
            //方法一内容
//            if (f[i][j]) {
//                ans.add(s.substring(i, j+1));
//                dfs(s, j+1);
//                //在存入结果后, 删除所有元素, 为下一套递归作准备
//                ans.remove(ans.size()-1);
//            }
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j+1));
                dfs(s, j+1);
                ans.remove(ans.size()-1);
            }
        }
    }

    //0-未判断, 1-是回文串, 2-不是回文串
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

