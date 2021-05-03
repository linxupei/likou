package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            //注意边界条件
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.getImportance(new int[]{2, 2, 3, 2}));
    }
}





