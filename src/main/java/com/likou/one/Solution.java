package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    /**
     * �����ȱ���ԭ�����ÿһ��Ԫ��, ���������鼴��
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        //�ж�ԭ����Ԫ�ظ����Ƿ�����������ͬ
        if (row*col != r*c) {
            return nums;
        }
        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[index/c][index%c] = nums[i][j];
                index++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(matrixReshape(new int[][]{{1,2,4,3},{1,2,4,3}}, 4, 2));
    }
}

