package com.likou.everyday;


import java.util.*;



public class Solution {

    /**
     * 从右上角开始, target大于当前值则向下走, 小于则向左走
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = col - 1, y = 0;
        while (true) {
            if (matrix[y][x] < target) {
                //target小于当前下标的正右结点, 说明target位于两个结点之间, 找不到目标
                if (x < col - 1 && matrix[y][x+1] > target) {
                    break;
                }
                y++;
                //越界
                if (y < 0 || y >= row) {
                    break;
                }
            } else if (matrix[y][x] > target) {
                x--;
                //越界
                if (x < 0 || x >= col) {
                    break;
                }
            } else {
                return true;
            }
        }
        return false;
    }



    public void main(String[] args) {

    }
}

