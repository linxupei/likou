package com.likou.everyday;


import java.util.*;

public class Solution {
    /**
     * 枚举上下边界, 计算每一列的和, 将二维数据转换一维数组
     * [A1, A2, A3,... Arows]表示在某上下边界内, 每一列的和组成的数组
     * Sj - Si <= k, 即该区间满足要求, 可转为Sj - k <= Si
     */
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ret = Integer.MIN_VALUE;
        //枚举上边界
        for (int i = 0; i < rows; i++) {
            int[] sum = new int[cols];
            //枚举下边界
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





