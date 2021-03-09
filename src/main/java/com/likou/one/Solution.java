package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public static int minCut(String s) {
        int n = s.length();
        boolean f[][] = new boolean[n][n];
        int g[] = new int[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        Arrays.fill(g, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = f[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }
        for (int i = 0; i < n; i++) {
            if (f[0][i]) {
                g[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (f[j+1][i]) {
                        g[i] = Math.min(g[i], g[j] + 1);
                    }
                }
            }
        }
        return g[n-1];
    }

    public static void main(String[] args) {
        minCut("abbab");
    }
}

