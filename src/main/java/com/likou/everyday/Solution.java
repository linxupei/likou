package com.likou.everyday;


import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * 使用动态规划的方法, 找出从左/右两个开始的当前下标最大值
     * 再取他们的两个的最小值即可
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
     * 使用下标单调递增栈统计
     */
    public static int trap_2(int[] height) {
        int result = 0;
        int length = height.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            //当当前下标的位置比栈中元素高时,说明可能存在接水的位置
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
     * 双指针+左/右统计当前下标最大值
     * 当左/右指针还未相遇时
     * 若height[left] < height[right], 说明leftMax < rightMax(由该算法遍历过程决定), 则result += leftMax - height[left]
     * 若height[left] >= height[right], 说明leftMax > rightMax(由该算法遍历过程决定), 则result += rightMax - height[right]
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

