package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {

    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.xorOperation(5, 1));
    }
}





