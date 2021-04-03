package com.likou.everyday;




public class Solution {
    /**
     * 将直方图分为3部分
     * 1.从左端点到最高端点
     * 2.从第一个最高端点到最后一个最高端点
     * 3.从右端点到最后一个最高端点
     */
    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int result = 0;
        int max = height[0];
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                left = i;
                right = i;
            } else if (height[i] == max) {
                right = i;
            }
        }
        //用于记录一个水槽的开始边界
        int start = 0;
        //从左端点到最高端点
        for (int i = 1; i < left; i++) {
            if (height[i] < height[start]) {
                result += height[start] - height[i];
            } else {
                start = i;
            }
        }
        //从第一个最高端点到最后一个最高端点
        for (int i = left + 1; i < right; i++) {
            result += height[left] - height[i];
        }
        start = n - 1;
        //从右端点到最后一个最高端点
        for (int i = n - 2; i > right; i--) {
            if (height[i] < height[start]) {
                result += height[start] - height[i];
            } else {
                start = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}

