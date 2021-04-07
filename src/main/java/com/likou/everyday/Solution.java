package com.likou.everyday;


import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * ʹ�ö�̬�滮�ķ���, �ҳ�����/��������ʼ�ĵ�ǰ�±����ֵ
     * ��ȡ���ǵ���������Сֵ����
     */
    public static int trap_1(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int []left = new int[length];
        int []right = new int[length];
        int result = 0;
        left[0] = height[0];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        right[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }

    /**
     * ʹ���±굥������ջͳ��
     */
    public static int trap_2(int[] height) {
        int result = 0;
        int length = height.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            //����ǰ�±��λ�ñ�ջ��Ԫ�ظ�ʱ,˵�����ܴ��ڽ�ˮ��λ��
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                result += currWidth * currHeight;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * ˫ָ��+��/��ͳ�Ƶ�ǰ�±����ֵ
     * ����/��ָ�뻹δ����ʱ
     * ��height[left] < height[right], ˵��leftMax < rightMax(�ɸ��㷨�������̾���), ��result += leftMax - height[left]
     * ��height[left] >= height[right], ˵��leftMax > rightMax(�ɸ��㷨�������̾���), ��result += rightMax - height[right]
     */
    public static int trap_3(int[] height) {
        int result = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(trap_3(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

