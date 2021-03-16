package com.likou.one;

import com.sun.deploy.util.StringUtils;
import netscape.security.UserTarget;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    /**
     * 层次遍历
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        List<Integer> result = new ArrayList<>(n);
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }

    /**
    * 模拟顺时针遍历
    **/
    public static List<Integer> spiralOrder1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        boolean[][] judge = new boolean[rows][cols];
        int row = 0, col = 0;
        List<Integer> result = new ArrayList<>(n);
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int index = 0;
        for (int i = 0; i < n; i++) {
            result.add(matrix[row][col]);
            judge[row][col] = true;
            //判断下一个位置是否超出边界或者已经遍历过
            int nrow = row + directions[index][0];
            int ncol = col + directions[index][1];
            if (nrow < 0 || nrow >= rows || ncol < 0 || ncol >= cols || judge[nrow][ncol]) {
                index = (index + 1) % 4;
            }
            row += directions[index][0];
            col += directions[index][1];
        }
        return result;
    }

    /**
     * 顺时针
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int total = n * n;
        boolean[][] judge = new boolean[n][n];
        int row = 0, col = 0, index = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for (int i = 0; i < total; i++) {
            result[row][col] = i + 1;
            judge[row][col] = true;
            //判断下一个位置是否超出边界或者已经遍历过
            int nrow = row + directions[index][0];
            int ncol = col + directions[index][1];
            if (nrow < 0 || nrow >= n || ncol < 0 || ncol >= n || judge[nrow][ncol]) {
                index = (index + 1) % 4;
            }
            row += directions[index][0];
            col += directions[index][1];
        }
        return result;
    }

    public static int[][] generateMatrix1(int n) {
        int[][] result = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int index = 1, total = n * n;
        while (index <= total) {
            for (int i = left; i <= right; i++) {
                result[top][i] = index++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = index++;
            }
            for (int i = right - 1; i >= left; i--) {
                result[bottom][i] = index++;
            }
            for (int i = bottom - 1; i > top; i--) {
                result[i][left] = index++;
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        generateMatrix(3);
        //spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}

