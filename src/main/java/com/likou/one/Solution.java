package com.likou.one;


import javafx.util.Pair;

import java.util.*;

class Solution {
    /**
     * ͨ�����ҹ���, ����matrix[i][j]������ת��䵽matrix[j][n-i-i]
     * ͨ����һ����ʹ��ԭ�ط�ת�ķ�ʽ
     * ͨ����ͼ��֪���ڳ���Ϊż���ľ�������ֻ��Ҫö��(n/2)*(n/2)��λ��
     * ����Ϊ�����ľ���������Ҫö��((n+1)/2)*((n+1)/2)��λ��
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
     * ��ת90��
     * �ɷֽ�Ϊ���¹���
     * 1.ˮƽ��ת
     * 2.���Խ��߷�ת
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //ˮƽ��ת
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }
        //�Խ��߷�ת
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

