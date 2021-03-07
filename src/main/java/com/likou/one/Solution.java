package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    /**
     * �˷����ܺ�������ѭ��������
     */
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return nums;
        }
        int n = (length << 1) - 1;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        //���ڼ�¼���ҵ���һ������ֵ�����ֵ����ֵ
        Stack<Integer> stack = new Stack<>();
        //��һ��֮��ջ�л��γ�һ�����ϸ�ݼ��ĵ�����
        for (int i = 0; i < n; i++) {
            //��ջ��С�ڵ�ǰ���ֵĳ�ջ
            while (!stack.isEmpty() && nums[i%length] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i%length];
            }
            stack.add(i%length);
        }
        return result;
    }

    /**
     * �˷�������δ���������ѭ������
     */
    public static int[] nextGreaterElements_(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return nums;
        }
        int[] result = new int[length];
        //���ڼ�¼���ҵ���һ������ֵ�����ֵ����ֵ
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //��һ��֮��ջ�л��γ�һ�����ϸ�ݼ��ĵ�����
        for (int i = 1; i < length; i++) {
            //��ջ��С�ڵ�ǰ���ֵĳ�ջ
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                max = Math.max(max, nums[stack.peek()]);
                result[stack.pop()] = nums[i];
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            //���һ����ջ��Ԫ��һ�������ֵ
            if (stack.isEmpty()) {
                result[num] = -1;
                break;
            }
            //�ų�ջ����ջ��Ԫ����ȵ����
            if (nums[num] < nums[stack.firstElement()]) {
                //�ж��Ƿ����ջ��, ����û���������ڵ�ǰ���ֵ���
                if (nums[num] < max) {
                    for (int i = 0; i < num; i++) {
                        if (nums[i] > nums[num]) {
                            result[num] = nums[i];
                            break;
                        }
                    }
                } else {
                    result[num] = nums[stack.firstElement()];
                }
            } else {
                //ջ����ջ��Ԫ�����
                result[num] = -1;
            }
        }
        return result;
    }

    /**
     * ����ջ
     * ע��:����һ��������ָ��nums1[i]��num2�е�λ�ÿ�ʼѰ��һ����nums1[i]�����Ԫ��
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int j : nums2) {
            while (!stack.isEmpty() && j > stack.peek()) {
                hashMap.put(stack.pop(), j);
            }
            stack.push(j);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static int nextGreaterElement(int n) {
        char[] chars = ("" + n).toCharArray();
        int i = chars.length - 2, j;
        while (i >= 0 && chars[i+1] <= chars[i]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        j = i + 1;
        while (j < chars.length) {
            if (chars[j] > chars[i]) {
                j++;
            } else {
                break;
            }
        }
        swap(chars, i, j-1);
        reverse(chars, i+1);
        try {
            return Integer.parseInt(new String(chars));
        } catch (Exception e) {
            return -1;
        }
    }

    public static void reverse(char[] chars, int start) {
        int i = start, j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        //nextGreaterElements(new int[]{3,-2,-3,-3,1,3,0});
        //nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7});
        System.out.println(nextGreaterElement(12443322));
    }
}

