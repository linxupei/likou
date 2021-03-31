package com.likou.everyday;


import java.util.*;



public class Solution {

    /**
     * �����Ͻǿ�ʼ, target���ڵ�ǰֵ��������, С����������
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = col - 1, y = 0;
        while (true) {
            if (matrix[y][x] < target) {
                //targetС�ڵ�ǰ�±�����ҽ��, ˵��targetλ���������֮��, �Ҳ���Ŀ��
                if (x < col - 1 && matrix[y][x+1] > target) {
                    break;
                }
                y++;
                //Խ��
                if (y < 0 || y >= row) {
                    break;
                }
            } else if (matrix[y][x] > target) {
                x--;
                //Խ��
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

