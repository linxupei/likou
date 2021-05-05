package com.likou.everyday;


import java.text.DecimalFormat;
import java.util.*;

public class Solution {
    /**
     * X xor X = 0
     * 0 xor X = X
     * X xor X xor Y  = Y
     */
    public int[] decode(int[] encoded, int first) {
        int length = encoded.length;
        int[] arr = new int[length + 1];
        arr[0] = first;
        for (int i = 1; i <= length; i++) {
            arr[i] = arr[i - 1] ^ encoded[i-1];
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decode(new int[]{2, 2, 3, 2}, 1));
    }
}





