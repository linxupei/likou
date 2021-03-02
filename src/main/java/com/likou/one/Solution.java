package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    /**
     * 利用区域前缀和即可
     */
    static class NumMatrix {
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row == 0) {
                return;
            }
            int col = matrix[0].length;
            if (col == 0) {
                return;
            }
            this.matrix = new int[row + 1][col + 1];
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    this.matrix[i][j] = this.matrix[i - 1][j] + this.matrix[i][j - 1] + matrix[i - 1][j - 1] - this.matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return matrix[row2 + 1][col2 + 1] - matrix[row1][col2 + 1] - matrix[row2 + 1][col1] + matrix[row1][col1];
        }
    }

    public static void main(String[] args) {
        NumMatrix temp = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}});
        System.out.println(temp.sumRegion(2, 1, 4, 3));
    }
}

