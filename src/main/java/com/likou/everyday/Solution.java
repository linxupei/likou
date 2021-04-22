package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * ö�����±߽�, ����ÿһ�еĺ�, ����ά����ת��һά����
     * [A1, A2, A3,... Arows]��ʾ��ĳ���±߽���, ÿһ�еĺ���ɵ�����
     * Sj - Si <= k, ������������Ҫ��, ��תΪSj - k <= Si
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ret = Integer.MIN_VALUE;
        //ö���ϱ߽�
        for (int i = 0; i < rows; i++) {
            int[] sum = new int[cols];
            //ö���±߽�
            for (int j = i; j < rows; j++) {
                for (int l = 0; l < cols; l++) {
                    sum[l] += matrix[j][l];
                }
                int count = 0;
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                for (int s : sum) {
                    count += s;
                    Integer ceil = treeSet.ceiling(count - k);
                    if (ceil != null) {
                        ret = Math.max(ret, count - ceil);
                        if (ret == k) {
                            return ret;
                        }
                    }
                    treeSet.add(count);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubmatrix(new int[][]{{2,2,-1}}, 0));
    }
}





