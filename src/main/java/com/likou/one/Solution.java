package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * ���(^), ���������ֻ�Ϊ������, �Ӹ�λ��ʼ�Ƚ�
     * ��ͬ��Ϊ0, ��ͬ��Ϊ1
     **/
    public static int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col>>1; j++) {
                A[i][j] ^= 1;
                A[i][col-j-1] ^= 1;
                int temp = A[i][j];
                A[i][j] = A[i][col-j-1];
                A[i][col-j-1] = temp;
            }
            if (col % 2 != 0) {
                A[i][col>>1] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][]{{1,1,0},
                                        {1,0,1},{0,0,0}}));
    }
}

