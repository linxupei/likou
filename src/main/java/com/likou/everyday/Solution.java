package com.likou.everyday;




public class Solution {
    /**
     * ��ֱ��ͼ��Ϊ3����
     * 1.����˵㵽��߶˵�
     * 2.�ӵ�һ����߶˵㵽���һ����߶˵�
     * 3.���Ҷ˵㵽���һ����߶˵�
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
        //���ڼ�¼һ��ˮ�۵Ŀ�ʼ�߽�
        int start = 0;
        //����˵㵽��߶˵�
        for (int i = 1; i < left; i++) {
            if (height[i] < height[start]) {
                result += height[start] - height[i];
            } else {
                start = i;
            }
        }
        //�ӵ�һ����߶˵㵽���һ����߶˵�
        for (int i = left + 1; i < right; i++) {
            result += height[left] - height[i];
        }
        start = n - 1;
        //���Ҷ˵㵽���һ����߶˵�
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

