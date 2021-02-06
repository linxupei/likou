package com.likou.one;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }

    /**
     * �����ݼ�����
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        int[] maxNums = new int[length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        maxNums[0] = nums[deque.peekFirst()];
        for (int i = k; i < length; i++) {
            //����ǰֵ�ȶ���ĩβֵ��, �Ƴ�����ĩβֵ
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //������ͷ���±겻���ϻ������ڷ�Χ���Ƴ�
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offer(i);
            maxNums[i-k+1] = nums[deque.peekFirst()];
        }
        return maxNums;
    }

    /**
     * ͨ�����ȶ���, �����
     * ����ǰ�±��Լ��±��Ӧ��ֵ����������
     * �ȱȽ�ֵ, �ٱȽ��±�
     */
    public static int[] maxSlidingWindow_(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0]-o1[0] : o2[1]-o1[1]);
        int[] maxNums = new int[length - k + 1];
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        maxNums[0] = priorityQueue.peek()[0];
        for (int i = k; i < length; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            //�����ڵ���±겻�ڻ������ڷ�Χ�ڵ�ʱ��, �Ƴ�
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            maxNums[i-k+1] = priorityQueue.peek()[0];
        }
        return maxNums;
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3));
    }
}

