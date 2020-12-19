package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * 通过查找规律, 发现matrix[i][j]经过翻转会变到matrix[j][n-i-i]
     * 通过这一规律使用原地翻转的方式
     * 通过画图易知对于长度为偶数的矩阵我们只需要枚举(n/2)*(n/2)个位置
     * 长度为奇数的矩阵我们需要枚举((n+1)/2)*((n+1)/2)个位置
     */
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }

    /**
     * 旋转90度
     * 可分解为如下过程
     * 1.水平翻转
     * 2.主对角线翻转
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //水平翻转
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }
        //对角线翻转
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    public static void main(String[] args) {

    }
}

