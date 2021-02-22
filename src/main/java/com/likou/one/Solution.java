package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * 遍历每一个元素(除上边界与左边界),与它左上角元素比较即可
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != matrix[i-1][j-1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 按照对角线遍历
     */
    public static boolean isToeplitzMatrix_1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int x = i+1, y = 1;
            while (x < row && y < col) {
                if (matrix[x][y] != matrix[x-1][y-1]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        for (int i = 1; i < col; i++) {
            int x = 1, y = i+1;
            while (x < row && y < col) {
                if (matrix[x][y] != matrix[x-1][y-1]) {
                    return false;
                }
                x++;
                y++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}}));
    }
}

