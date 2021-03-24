package com.likou.everyday;


import java.util.*;

public class Solution {
    public static boolean find132pattern1(int[] nums) {
        int[] stack = new int[3];
        int n = nums.length;
        int index = 0;
        if (n < 3) {
            return false;
        }
        for (int j = 0; j < n - 2; j++) {
            index = 0;
            stack[index] = nums[j];
            for (int i = j; i < n; i++) {
                if (nums[i] < stack[index] && index == 0) {
                    stack[index] = nums[i];
                    if (i > j) {
                        j = i;
                    }
                }
                if (nums[i] > stack[index]) {
                    if (index == 0) {
                        index++;
                    }
                    stack[index] = nums[i];
                }
                if (index == 1 && nums[i] < stack[1] && nums[i] > stack[0]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * i<j<k && nums[i] < nums[k] < nums[i]
     * 使用leftMin记录当前下标(j)的左边的最小值表示(i)
     * 使用TreeMap记录当前下标的右边的所有值TreeMap使用红黑树实现
     * 其中一个函数ceilingKey(value)可查找第一个比value大或等于value的值
     */
    public static boolean find132pattern2(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int leftMin = nums[0];
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
        for (int i = 2; i < n; i++) {
            rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < n - 1; i++) {
            if (leftMin < nums[i]) {
                Integer k = rightAll.ceilingKey(leftMin + 1);
                if (k != null && k < nums[i]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[i]);
            rightAll.put(nums[i + 1], rightAll.get(nums[i + 1]) - 1);
            if (rightAll.get(nums[i + 1]) <= 0) {
                rightAll.remove(nums[i + 1]);
            }
        }
        return false;
    }

    /**
     * i<j<k && nums[i] < nums[k] < nums[j]
     * 从后往前遍历
     * max_k用于维护k能成为的最大值
     * 使用单调栈(从栈顶到栈底分别从小排到大)
     * 对于每一个元素
     * 首先考虑是否能成为i, 若能, 则找到答案
     * 然后考虑是否能成为j, 不断与栈顶元素比较, 若大于则弹出的元素可能成为k, 最后放入队列
     * 遍历结束没找到一组数据, 则无解
     */
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        Integer max_k = Integer.MIN_VALUE;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[n-1]);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < max_k) {
                return true;
            }
            if (!stack.isEmpty() && nums[i] > stack.peek()) {
                max_k = stack.pop();
            }
            if (nums[i] > max_k) {
                stack.push(nums[i]);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3,5,0,3,4}));
    }
}

